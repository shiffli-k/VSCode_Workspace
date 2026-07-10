package com.learn.microservice.serviceb.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBRestController {

    @GetMapping(path = "/")
    public ResponseEntity<String> basePath(){
        StringBuilder responseMessage = new StringBuilder();
        responseMessage.append("Hello from Service B!");
        return ResponseEntity.ok(responseMessage.toString());
    }
}
