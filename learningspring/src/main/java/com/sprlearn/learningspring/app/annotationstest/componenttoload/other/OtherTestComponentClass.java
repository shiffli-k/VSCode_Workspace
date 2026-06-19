package com.sprlearn.learningspring.app.annotationstest.componenttoload.other;

import java.time.LocalTime;

public class OtherTestComponentClass {

    private LocalTime loadTime;

    public OtherTestComponentClass(){
        System.out.println("\n\nOtherTestComponentClass loaded\n\n");
        this.loadTime = LocalTime.now();
    }

    public LocalTime getLoadTime(){
        return this.loadTime;
    }
}
