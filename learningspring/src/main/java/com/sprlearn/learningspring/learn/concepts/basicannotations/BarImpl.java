package com.sprlearn.learningspring.learn.concepts.basicannotations;

import org.springframework.stereotype.Component;

@Component()
public class BarImpl implements FooBarInterface{

    @Override
    public String doSomething() {
        return "Bar did something";
    }

    @Override
    public String doSomeotherThing() {
        return "Bar did some-otherthing";
    }

}
