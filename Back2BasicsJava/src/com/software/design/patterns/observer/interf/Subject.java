package com.software.design.patterns.observer.interf;

public interface Subject {

    public void subscribe(Observer theObserver);
    public void unSubscribe(Observer theObserver);
    public void pushMessageToSubscribers(String messageToPush);


}
