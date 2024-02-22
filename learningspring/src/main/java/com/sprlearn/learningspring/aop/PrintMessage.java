package com.sprlearn.learningspring.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PrintMessage {

    @GetMapping("/welcome")
    public ResponseEntity<String> print() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello!");
    }

    @GetMapping("{msg}/print")
    public ResponseEntity<String> print(@PathVariable(value = "msg") String message) {
        return ResponseEntity.status(HttpStatus.OK).body("Yes, " + message);
    }

    public ModelAndView

}
