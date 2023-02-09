package com.example.weatherreport.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherServerTest {

    @Test
    public void testUpdate(){
        WeatherServer weatherServer = new WeatherServer();
        weatherServer.init();
        weatherServer.update();
    }
}
