package com.wg.waimao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CODSConfig {
  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("http://localhost:8080");
    config.addAllowedOrigin("http://www.zhuland.com");
    config.addAllowedOrigin("http://59.110.67.115:8080");
    config.addAllowedOrigin("http://192.168.2.34:8080");
    config.addAllowedOrigin("http://192.168.2.45:9999");
    config.setAllowCredentials(Boolean.valueOf(true));
    config.addAllowedMethod("OPTIONS");
    config.addAllowedMethod("HEAD");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("DELETE");
    config.addAllowedMethod("PATCH");
    config.setMaxAge(Long.valueOf(3600L));
    config.addAllowedHeader("*");
    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    configSource.registerCorsConfiguration("/**", config);
    return new CorsFilter((CorsConfigurationSource)configSource);
  }
}
