package com.resilience.simulate.resiliantservice.starterspring;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.common.ratelimiter.configuration.RateLimiterConfigCustomizer;

@Configuration
public class ResilienceConfig {

    @Bean
    public RateLimiterConfigCustomizer customRateLimiter(){
        
        return RateLimiterConfigCustomizer.of(
            "programaticRateLimit", 
            limiter -> limiter
            .limitForPeriod(5)
            .limitRefreshPeriod(Duration.ofSeconds(10))
            .timeoutDuration(Duration.ofSeconds(4))
        );
        
    }
}
