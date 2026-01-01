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
    public String basePath() {
        log.debug("Health check Request");
        return "Up and Running!";
    }
    

    @GetMapping("/welcome")
    public ResponseEntity<String> print() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello!");
    }

    @GetMapping("{msg}/print")
    public ResponseEntity<String> print(@PathVariable(value = "msg") String message) {
        return ResponseEntity.status(HttpStatus.OK).body("Yes, " + message);
    }

    @PostMapping("/jsonApi")
    public ResponseEntity<String> jsonApiHandler(@Valid @RequestBody ApiRequestDTO reqObj) {
        
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}
