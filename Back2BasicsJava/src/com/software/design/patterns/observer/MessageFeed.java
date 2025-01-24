package com.software.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

import com.software.design.patterns.observer.interf.Observer;
import com.software.design.patterns.observer.interf.Subject;

public class MessageFeed implements Subject{

    public static enum contentType{
        Java, JS, Python, Others
    }

    private List<Observer> listOfSubscribers = new ArrayList<>();
    private contentType theTopicOfMessageFeed;

    public MessageFeed(contentType subscriptionContent){
        this.theTopicOfMessageFeed = subscriptionContent;
    }

    @Override
    public void subscribe(Observer theObserver) {
        listOfSubscribers.add(theObserver);
        return;
    }

    @Override
    public void unSubscribe(Observer theObserver) {
        listOfSubscribers.remove(theObserver);
        return;
    }

    @Override
    public void pushMessageToSubscribers(String messageToPush) {
        listOfSubscribers.forEach(eachSubscriber -> {
            eachSubscriber.sendMessageToObserver("Hello Subscriber, on the topic of "+theTopicOfMessageFeed+" We have a message: "+messageToPush);
        });
        return;
    }

}
