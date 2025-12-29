package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerJwtConfig {
    @Bean
        public JwtTokenProvider jwtTokenProvider() {
    return new JwtTokenProvider("secret", 86400000);
    }

    @Bean
    public Components swaggerComponents() {
        return new Components()
            .addSecuritySchemes("bearerAuth",
                new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
            );
    }
}