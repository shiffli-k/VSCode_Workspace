package com.learn.microservice.serviceb.api.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBRestController {

    private AtomicInteger hitCounter = new AtomicInteger(0);

    @GetMapping(path = "/")
    public ResponseEntity<String> basePath(){
        StringBuilder responseMessage = new StringBuilder();
        responseMessage.append("Hello from Service B!");
        responseMessage.append("\nHitCounter is " + hitCounter.incrementAndGet());
        return ResponseEntity.ok(responseMessage.toString());
    }
}
