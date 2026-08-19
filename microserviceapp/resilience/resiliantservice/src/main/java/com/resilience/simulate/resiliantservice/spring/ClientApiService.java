package com.resilience.simulate.resiliantservice.spring;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.resilience.annotation.ConcurrencyLimit;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ClientApiService {
    private static final Logger log = LoggerFactory.getLogger("Resilianct Client");

    @Retryable(
        includes = Exception.class,
        // excludes = RuntimeException.class
        maxRetries = 5,
        delay = 1000,
        multiplier = 3,
        jitter = 250,
        maxDelay = 10000
        
    )
    public void getRespRetryable(){

        log.info("Triggering Request");

        log.info(
            "Response: " + 
            RestClient.create("http://localhost:8000/test").get().retrieve().body(String.class)
        );
            
    }

    @ConcurrencyLimit(limit = 4)
    public void limitedConcurrentRequest(){
        log.info("Process started at : " + Thread.currentThread().getName());
        try {
            Thread.sleep(Duration.ofSeconds(10));
        } catch (Exception e) {
            // do Nothing
        }
        log.info("Process completed at : " + Thread.currentThread().getName());
    }

}
