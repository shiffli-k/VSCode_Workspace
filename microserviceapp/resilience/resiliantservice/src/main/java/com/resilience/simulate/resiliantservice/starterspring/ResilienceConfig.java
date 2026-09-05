package com.resilience.simulate.resiliantservice.starterspring;

import java.time.Duration;

import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.common.ratelimiter.configuration.RateLimiterConfigCustomizer;

@Configuration
public class ResilienceConfig {

    public RateLimiterConfigCustomizer customRateLimiter(){
        
        return RateLimiterConfigCustomizer.of("programaticRateLimit", retry -> 
            retry.limitForPeriod(5).limitRefreshPeriod(Duration.ofSeconds(10))
        );
        
    }
}
