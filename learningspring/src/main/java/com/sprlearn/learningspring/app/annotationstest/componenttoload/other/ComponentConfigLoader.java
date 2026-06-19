package com.sprlearn.learningspring.app.annotationstest.componenttoload.other;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfigLoader {

    @Bean
    public OtherTestComponentClass loadOtherTestComponent(){
        return new OtherTestComponentClass();
    }
}
