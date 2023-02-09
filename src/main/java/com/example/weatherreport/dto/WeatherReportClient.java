package com.example.weatherreport.dto;

import java.text.MessageFormat;

public class WeatherReportClient extends Observer {

    private String name;
    public WeatherReportClient(String name,WeatherInfo weatherInfo){
        this.name = name;
        this.weatherInfo = weatherInfo;
        this.weatherInfo.attach(this);
    }

    private final String logFormat = "Client:{0},Time:{1},Temperature:{2}, humidity:{3}, and pressure:{4}";
    public void log(){
        System.out.println(MessageFormat.format(logFormat,this.name
                ,this.weatherInfo.getDate()
                ,this.weatherInfo.getTemperature()
                ,this.weatherInfo.getHumidity()
                ,this.weatherInfo.getPressure()));

    }
}
