package com.learn.jwt.jwtserver;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
public class GreetingHandler {

    @PostMapping("/greet")
    public ResponseEntity<String> greetRequestHandlerEntity(@RequestBody String reqBody, @RequestHeader Map<String, String> reqHeader) {
        
        return ResponseEntity.ok().body("Welcome! "+reqBody);
    }
    

}
