package com.backtobasics.pkg.jav.lng.test;

public class BasicCounter {

    private long counterValue = 0L;

    public BasicCounter click(){
        counterValue++;
        return this;
    }
    public BasicCounter clickTimes(long timesToClick){
        counterValue+=timesToClick;
        return this;
    }
    
    public String getCurrentValue(){
        return Long.toString(counterValue);
    }
    

}
