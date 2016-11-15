package com.bigfield.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:api.properties")
public class GrunaviConfig {

  @Value("${grunavi.api.key}")
  private String gNaviapiKey;

  @Bean
  public GrunaviApi grunaviApi() {
    String herokuApiConfig = System.getenv("grunavi_api_key");
    if (herokuApiConfig != null) {
      return new GrunaviApi(herokuApiConfig);
    }
    return new GrunaviApi(gNaviapiKey);
  }

}
