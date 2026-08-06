package com.springbootcloud.mydiscoverableservice.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiHandler {

    @GetMapping("/")
    public ResponseEntity<String> basePathEntity() {
        return ResponseEntity.ok("Welcome!");
    }
    
}
