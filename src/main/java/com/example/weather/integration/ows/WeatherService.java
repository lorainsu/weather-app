package com.example.weather.integration.ows;

import java.io.IOException;

import com.example.weather.PropertiesUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Cacheable("weather")
    public Weather getWeather(String country, String city) {
        logger.info("Requesting current weather for {}/{}", country, city);

        String weatherdata = PropertiesUtils.getValue(city);

        if (!StringUtils.isEmpty(weatherdata)) {
            ObjectMapper objMapper = new ObjectMapper();
            Weather weather = null;
            try {
                weather = objMapper.readValue(weatherdata, Weather.class);
            } catch (IOException e) {
                logger.error("weatherdata config error:" + weatherdata, e);
            }

            return weather;
        }
        return null;
    }

}

