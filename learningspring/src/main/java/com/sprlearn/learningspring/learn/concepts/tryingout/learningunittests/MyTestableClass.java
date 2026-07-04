package com.sprlearn.learningspring.learn.concepts.tryingout.learningunittests;

import org.springframework.stereotype.Service;

@Service
public class MyTestableClass {
    private int methodCallCounter = 0;
    
    
    private final MyDepdendentClass myDepdendentClass;

    public MyTestableClass(MyDepdendentClass bean4MyDepdendentClass){
        this.myDepdendentClass = bean4MyDepdendentClass;
    }
    
    public boolean isEven(int valToCheck){
        ++methodCallCounter;
        return valToCheck%2==0;
    }

    public boolean isEvenExternal(int valToCheck){
        ++methodCallCounter;
        return this.myDepdendentClass.isEven_Dependent(valToCheck);
    }

    public int getCallCounter(){
        return this.methodCallCounter;
    }
}
