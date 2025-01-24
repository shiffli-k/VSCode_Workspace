package com.software.design.patterns.observer;

import com.software.design.patterns.observer.interf.Observer;

public class MessageFeedSubscriber implements Observer{

    private String userName;

    public MessageFeedSubscriber(String userName){
        this.userName = userName;
    }

    @Override
    public void sendMessageToObserver(String messageToSend) {
        System.out.println(messageToSend.replace("Subscriber", this.userName));
    }

    public String getSubscriberName(){
        return this.userName;
    }

}
