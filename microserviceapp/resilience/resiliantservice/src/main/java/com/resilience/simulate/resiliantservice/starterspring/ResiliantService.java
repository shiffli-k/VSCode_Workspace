package com.resilience.simulate.resiliantservice.starterspring;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ResiliantService {

    private static final Logger log = LoggerFactory.getLogger("TheResiliantService");

    /* 
        How R4J handles reseliance
        
        retry -> CB -> RateLimit -> Bulkhead -> MyMethod

        Exceptions are propogated in reverse order
    
    */


    @Retry(name = "baseretryconfig", fallbackMethod = "fallback4Retry")
    @RateLimiter(name = "baselimit", fallbackMethod = "fallback4RateLimit")
    public String getWeatherInfo(String cityName){

        log.info("Returning Response for: " + cityName);
        
        if(Objects.isNull(cityName)) throw new RuntimeException("City name is null!");

        return "City %s is sunny".formatted(cityName); 
    }


    public String fallback4Retry(String cityName, Throwable t){
        log.warn("Retry attempts failed " + t.getMessage());
        return "Retry attempts failed -> "+ t.getMessage();
    }


    public String fallback4RateLimit(String cityName, RequestNotPermitted t){
        log.warn("Rate Limit has been reached! " + t.getMessage());
        return "Rate Limit has been reached! -> "+ t.getMessage();
    }
}
