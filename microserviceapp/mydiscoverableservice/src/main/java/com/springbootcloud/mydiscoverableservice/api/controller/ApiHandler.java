package com.springbootcloud.mydiscoverableservice.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiHandler {

    private static final Logger LOG = LoggerFactory.getLogger("APIController");

    @GetMapping("/")
    public ResponseEntity<String> basePathEntity() {
        LOG.info("Responding here");
        return ResponseEntity.ok("Welcome!");
    }
    
}
