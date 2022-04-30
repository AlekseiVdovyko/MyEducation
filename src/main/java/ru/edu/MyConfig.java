package ru.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:app.properties")
public class MyConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WeatherProvider weatherProvider() {
        return new WeatherProvider(restTemplate());
    }

    @Bean
    public WeatherCache weatherCache() {
        return new WeatherCache();
    }
}
