package com.sprlearn.learningspring.learn.concepts.basicannotations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FooImpl implements FooBarInterface{

    @Override
    public String doSomething() {
       return "Foo did something";
    }
    
    @Override
    public String doSomeotherThing() {
       return "Foo did some-otherthing";
    }

}
