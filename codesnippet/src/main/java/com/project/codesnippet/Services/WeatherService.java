package com.project.codesnippet.Services;

import java.util.List;
import java.util.Optional;

import com.project.codesnippet.Entity.Weather;

public interface WeatherService {
    

    public Weather writeWeather(Weather weather);
    
    public List<Weather> getAllWeathers();

    public Optional <Weather> getWeather(Integer cityId);

    public Weather updateWeather(Integer cityId, Weather weather);

}
