package com.sprlearn.learningspring.security;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class SpringSecurityHello {

    @GetMapping("/security")
    public String springSecurityHelloString() {
        return new String("Hello and Welcome!");
    }
    
}
