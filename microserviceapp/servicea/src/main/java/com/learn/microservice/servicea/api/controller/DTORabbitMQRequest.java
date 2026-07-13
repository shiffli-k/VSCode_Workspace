package com.learn.microservice.servicea.api.controller;

public class DTORabbitMQRequest {

    private String exchangeName;
    private String routingKey;
    private String messageData;

    public DTORabbitMQRequest(String exchangeName, String routingKey, String messageData) {
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
        this.messageData = messageData;
    }

    public String getExchangeName() {
        return exchangeName;
    }
    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
    public String getRoutingKey() {
        return routingKey;
    }
    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
    public String getMessageData() {
        return messageData;
    }
    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    @Override
    public String toString() {
        return "RequestData [exchangeName=" + exchangeName + ", routingKey=" + routingKey + ", messageData="
                + messageData + "]";
    }
    
}
