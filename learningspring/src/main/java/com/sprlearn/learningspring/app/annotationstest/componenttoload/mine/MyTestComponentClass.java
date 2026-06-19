package com.sprlearn.learningspring.app.annotationstest.componenttoload.mine;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class MyTestComponentClass {

    private final LocalTime classCreatedTime ;

    public MyTestComponentClass(){
        System.out.println("\n\nMyTestComponentClass loaded\n\n");
        this.classCreatedTime = LocalTime.now();
    }

    public LocalTime getLoadedTime(){
        return this.classCreatedTime;
    }

}
