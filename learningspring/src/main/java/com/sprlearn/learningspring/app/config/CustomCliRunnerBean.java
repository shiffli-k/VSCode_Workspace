package com.sprlearn.learningspring.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCliRunnerBean implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring booted gracefully! Here are some arguments!");
        for(String eachArgs : args) System.out.println("Arg: " + eachArgs);
    }

}
