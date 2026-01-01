package com.sprlearn.learningspring.app.filterinterceptors;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppFilterConfig {
    
    @Bean
    public FilterRegistrationBean<MyAppFilter> myAppFilter(){
        FilterRegistrationBean<MyAppFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new MyAppFilter());
        reg.addUrlPatterns("/*");
        reg.setOrder(1);
        return reg;
    }
}
