package com.sprlearn.learningspring.learn.concepts.basicannotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier(value = "foo")
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
