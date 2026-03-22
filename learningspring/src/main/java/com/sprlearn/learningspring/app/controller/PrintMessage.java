package com.sprlearn.learningspring.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprlearn.learningspring.app.dto.ApiRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "/apis/v1/")
public class PrintMessage {

    private static final Logger log = LoggerFactory.getLogger(PrintMessage.class);

    @PostConstruct
    private void onCreation(){
        log.info("API Controller Ready!");
    }

    @PreDestroy
    private void onDestroy(){
        log.info("Shutting down API Controller");
    }

    @GetMapping("/")
    @Operation(summary = "Base endpoint", description = "Responds if app is up and running")
    @Tag(name = "App Status", description = "Just for checking if app is up and running")
    public String basePath() {
        log.debug("Health check Request");
        return "Up and Running!";
    }
    
    
    @GetMapping("/welcome")
    @Operation(summary = "The Welcome", description = "Responds will a fixed hello message")
    @Tag(name = "App Status", description = "Just for checking if app is up and running")
    public ResponseEntity<String> print() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello!");
    }

    @GetMapping("{msg}/print")
    @Tag(name = "Core Application API", description = "The actual functional APIs")
    public ResponseEntity<String> print(@PathVariable(value = "msg") @Parameter(description = "The message you want to be responded with", example = "Hello!") String message) {
        return ResponseEntity.status(HttpStatus.OK).body("Yes, " + message);
    }
    
    @PostMapping("/jsonApi")
    @Tag(name = "Core Application API", description = "The actual functional APIs")
    public ResponseEntity<String> jsonApiHandler(@Valid @RequestBody ApiRequestDTO reqObj) {
        
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}
