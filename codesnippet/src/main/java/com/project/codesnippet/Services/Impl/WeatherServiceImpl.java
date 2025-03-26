package com.project.codesnippet.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.project.codesnippet.Entity.Weather;
import com.project.codesnippet.Repositories.WeatherRepo;
import com.project.codesnippet.Services.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherRepo weatherRepo;


    @Override
    public Weather writeWeather(Weather weather) {
    
        Weather save = this.weatherRepo.save(weather);

        return save;
    }

    @Override
    public List<Weather> getAllWeathers() {
    
        List<Weather> all = this.weatherRepo.findAll();

        return all;
    }

    @Override
    @Cacheable(value = "weather", key="#city")                                                   //Cache Implemented
    public Optional <Weather> getWeather(Integer cityId) {
    
        Optional<Weather> weather = this.weatherRepo.findById(cityId);

         /* 
         ! As we are using Optional, so if City Id is not found then in response body we will get Null & 
         !                                  No Error will be Thrown
         */
         
        return weather;
    }

    @Override
    @CachePut(value = "weather", key="#city")                                           //CachePut usage
    public Weather updateWeather(Integer cityId, Weather weather) {
    
        Weather w = this.weatherRepo.findById(cityId).orElseThrow(()-> new RuntimeException());

        w.setCityname(weather.getCityname());
        w.setWeather(weather.getWeather());

        Weather save = this.weatherRepo.save(w);
        return save;

    }


    /* 
     ! CachePut is used in Update works/put apis because if you don't use @CachePut then on Put Call DB will be updated
     !                              But Cache will NOT BE Updated.

     !                      So CachePut will do the update in Cache in Put Calls.

     ?      But, if you do update a 2nd time, again CachePut will not work & will stick with the Old Data.

     ?                  This happens because Internally in Cache a HashMap is created with Key Value pairs

     ? So for the 2nd Update a new Map with Different Key will be Created which doesn't match with the Key of 
     !                       @Cacheable 

     !                                  Hence we need to provide/define same key explicitly to both 
     !                @Cacheable & @CachePut
     !                                           And then only it will Work fine.   
     
     
     ? Here in the above example due to some reason key is not working & showing Error, but this how it
     ?                       works in real time. 
     ?                                                      Refer Code Snippet for more guidance.
     */
    
}
