package com.example.weatherreport.server;

import com.example.weatherreport.dto.WeatherInfo;
import com.example.weatherreport.dto.WeatherReportClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class WeatherServer {

    private WeatherInfo weatherInfo = new WeatherInfo();


    @PostConstruct
    public void init(){
        for(int i = 0;i<5;i++){
            new WeatherReportClient("client"+i,weatherInfo);
        }
        System.out.println("====== init complete=========");
    }

    @Scheduled(cron ="0 * * * * ?")
    public void update(){
        Double temperature = getRandom();
        Double humidity = getRandom();
        Double pressure = getRandom();
        Date date = new Date();
        weatherInfo.update(temperature,humidity,pressure,date);
    }

    private Double getRandom(){
        BigDecimal bigDecimal = new BigDecimal(Math.random() * 10).setScale(2,BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}
