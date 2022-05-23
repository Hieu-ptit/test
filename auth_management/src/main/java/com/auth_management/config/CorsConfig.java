package com.auth_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "https://sun-oil-admin-staging.web.app", "http://localhost:4300",
                                "https://sun-oil-admin.web.app", "https://sun-oil.web.app")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                        .allowedHeaders("X-Auth-Token", "Content-Type", "Authorization", "Content-Length",
                                "Access-Control-Allow-Headers", "Origin", "Access-Control-Allow-Origin",
                                "X-Requested-With", "accessToken", "authorization", "access_token", "secret-key")
                        .allowCredentials(true)
                        .maxAge(48000);
            }
        };
    }
}
