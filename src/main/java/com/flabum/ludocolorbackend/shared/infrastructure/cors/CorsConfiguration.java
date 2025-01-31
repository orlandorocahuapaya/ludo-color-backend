package com.flabum.ludocolorbackend.shared.infrastructure.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173",
                                "https://ludocolor-backend-production.up.railway.app",
                                "https://ludocolor-backend-production.up.railway.app/swagger-ui/index.html")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("Authorization") // Permite ver el header Authorization en la respuesta
                        .allowCredentials(true);
            }
        };
    }
}
