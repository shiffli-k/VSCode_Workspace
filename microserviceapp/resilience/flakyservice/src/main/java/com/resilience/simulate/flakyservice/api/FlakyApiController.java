package com.resilience.simulate.flakyservice.api;

import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class FlakyApiController {

    private static final Logger log = LoggerFactory.getLogger("Flaky API Controller");
    
    private final AtomicInteger HIT_COUNTER = new AtomicInteger(0);

    @GetMapping(path = "/")
    public ResponseEntity<String> basePath() {
        return ResponseEntity.ok("Service is Up! + Hit counter is at : " + HIT_COUNTER.get());
    }

    @GetMapping(path = "/inc")
    public ResponseEntity<String> incrementCounter(
        @RequestParam(name = "incrementby", required = false, defaultValue = "0") int incrementBy
    ){
        HIT_COUNTER.addAndGet(incrementBy);
        log.info("Incrementing from " + HIT_COUNTER.get());
        return ResponseEntity.ok("Counter is: " + HIT_COUNTER.incrementAndGet());
    }
    
    @GetMapping(path = "/delayedEndpoint")
    public ResponseEntity<String> getDelayedResponseByHITCounter() throws InterruptedException{
        Duration delayDuration = Duration.ofMillis(HIT_COUNTER.get() * 250);
        
        log.info("Delaying API Response by: " + delayDuration.toMillis());

        Thread.sleep(delayDuration);

        return ResponseEntity.ok("Response Delayed by: " + delayDuration.toMillis());
    }


    
}
