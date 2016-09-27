package com.bigfield.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrunaviConfig {

    @Bean
    public GrunaviApi grunaviApi() {
        return new GrunaviApi("35214ad59b8f8771a0d090041b391b05");
    }

}
