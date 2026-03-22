package com.sprlearn.learningspring.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApiConfig4Swagger() {

        return new OpenAPI().info(
            new Info()
                .title("LearnSpringProject")
                .version("0.0.1-PreAlpha")
                .description("Just an app for me to learn Spring boot and Spring in general!")
        );
    }
}
