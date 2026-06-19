package com.sprlearn.learningspring.app.annotationstest;

import org.springframework.web.bind.annotation.RestController;

import com.sprlearn.learningspring.app.annotationstest.componenttoload.mine.MyTestComponentClass;
import com.sprlearn.learningspring.app.annotationstest.componenttoload.other.ComponentConfigLoader;
import com.sprlearn.learningspring.app.annotationstest.componenttoload.other.OtherTestComponentClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestingAnnotations {

    @Autowired
    private MyTestComponentClass t1;

    @Autowired
    private OtherTestComponentClass t2;

    @GetMapping(path = "/")
    public ResponseEntity<String> base(@RequestParam(defaultValue = "none", name = "p") String param1) {
        StringBuilder respMessage = new StringBuilder("Yes: " + param1);

        respMessage.append(" | \n LoadTime1: " + t1.getLoadedTime().toString());
        respMessage.append(" | \n LoadTime2: " + t2.getLoadTime().toString());

        return ResponseEntity.ok(respMessage.toString());
    }    
    
}
