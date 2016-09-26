package com.bigfield.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrunaviConfig {

    @Bean
    public GrunaviApi grunaviApi() {
        return new GrunaviApi(System.getenv("GRUNAVI_KEY"));
    }

}
