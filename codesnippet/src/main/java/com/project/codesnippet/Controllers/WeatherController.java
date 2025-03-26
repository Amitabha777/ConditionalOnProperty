package com.project.codesnippet.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.codesnippet.Entity.Weather;
import com.project.codesnippet.Services.WeatherService;

@RestController
@RequestMapping("/api/city/weather")
public class WeatherController {
    
    @Autowired
    WeatherService weatherService;

    @PostMapping("")
    public ResponseEntity<Weather> writeCityWeather(@RequestBody Weather weather)
    {
        Weather writeWeather = this.weatherService.writeWeather(weather);

        return new ResponseEntity<Weather>(writeWeather,HttpStatus.CREATED);
    }


    @GetMapping("/{cid}")
    public ResponseEntity<Optional<Weather>> getCityWeather(@PathVariable Integer cid)
    {
        Optional<Weather> weather = this.weatherService.getWeather(cid);                        

        /* 
         ! As we are using Optional, so if City Id is not found then in response body we will get Null & 
         !                                  No Error will be Thrown
         */

        return new ResponseEntity<Optional <Weather>>(weather, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Weather>> getAllCityWeatherUpdate()
    {
        List<Weather> allWeathers = this.weatherService.getAllWeathers();

        return new ResponseEntity<>(allWeathers, HttpStatus.OK);
    }


    @PutMapping("/{cid}")
    public ResponseEntity<Weather> updateCityWeather(@PathVariable Integer cid, @RequestBody Weather weather)
    {
        Weather updateWeather = this.weatherService.updateWeather(cid, weather);

        return new ResponseEntity<>(updateWeather, HttpStatus.OK);
    }

}
