package com.example.weatherreport.dto;

import java.io.Serializable;

public abstract class Observer implements Serializable {
    protected WeatherInfo weatherInfo;

    void log(){};
}
