package com.example.weatherreport.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherInfo implements Serializable {

    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Date date;

    private List<WeatherReportClient> observers = new ArrayList<>();

    public void attach(WeatherReportClient weatherReportClient){
        observers.add(weatherReportClient);
    }

    public void remove(WeatherReportClient weatherReportClient){
        observers.remove(weatherReportClient);
    }

    public void update(Double temperature,Double humidity,Double pressure,Date date){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.date = date;
        notifyAllObservers();
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.log();
        }
    }

    public Double getTemperature() {
        return temperature;
    }


    public Double getHumidity() {
        return humidity;
    }


    public Double getPressure() {
        return pressure;
    }

    public Date getDate() {
        return date;
    }


}
