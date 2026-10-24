package com.resilience.simulate.resiliantservice.starterspring;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
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

    public CircuitBreakerConfigCustomizer baseCircuitBreakerConfig(){
        return CircuitBreakerConfigCustomizer.of("baseCB", 
            cbBuilder -> cbBuilder
                .slidingWindowSize(10) // Observe based on last 10 calls
                
                // .failureRateThreshold(50)  // Break open if 50% or more failure

                .slowCallRateThreshold(50) // Break open if 50% or more slow APIs
                .slowCallDurationThreshold(Duration.ofSeconds(5)) // Threshold of call Rates

                .waitDurationInOpenState(Duration.ofSeconds(10)) // Wait during open state

                .permittedNumberOfCallsInHalfOpenState(5)
        );
    }
}
