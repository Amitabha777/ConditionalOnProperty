package com.project.codesnippet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.codesnippet.Entity.Weather;

public interface WeatherRepo extends JpaRepository<Weather, Integer>{
    
}
