package com.learn.microservice.servicea.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservice.servicea.api.service.ClientApiService;
import com.rabbitmq.client.RpcClient.Response;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ServiceARestController {

    private final Logger LOG = LoggerFactory.getLogger(ServiceARestController.class);
    
    public static final String RABBIT_MQ_QUQUE_NAME = "MyQ1";

    // HTTP API Clients
    private ClientApiService javaRestClient;
    
    // Message Brokers
    private RabbitTemplate rabbitMq;
    
    // Constructors
    public ServiceARestController(ClientApiService springObjJavaRestClientService, RabbitTemplate springBeanRabbitTemplate){
        this.javaRestClient = springObjJavaRestClientService;
        this.rabbitMq = springBeanRabbitTemplate;
    }
    
    /*--------------------------------------------------------------------------------------------------- */

    @GetMapping(path = "/")
    public ResponseEntity<String> basePath(){
        StringBuilder responseMessage = new StringBuilder("Hello and welcome from Service A \n");
        
        // responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.JAVA));
        // responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.SPRING_LEGACY));
        // responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.SPRING_LATEST));
        responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.SPRING_CLOUD_OPEN_FEIGN));

        return ResponseEntity.ok(responseMessage.toString());
    }

    @PostMapping("/")
    public ResponseEntity<String> basePath(@RequestBody String requestBody) {
        StringBuilder response = new StringBuilder("Message Sent");

        rabbitMq.convertAndSend(RABBIT_MQ_QUQUE_NAME, requestBody);
        
        return ResponseEntity.ok(response.toString());
    }


    /*--------------------------------------------------------------------------------------------------- */

    @PostConstruct
    public void settingUpCallbacksRabbitMQ(){
        LOG.info("Initializing Callbacks for RabbitMQ");

        // Broker got the message
        rabbitMq.setConfirmCallback((correlationData, ack, cause) -> {
            if(ack)
                LOG.info("Message received by broker");
            else
                LOG.error("Message not sent due to: " + cause);
            return;
        });

        // Callback
        rabbitMq.setReturnsCallback(returnedMessage -> {
            LOG.error("Message " + returnedMessage.getMessage() + " Failed due to: " + returnedMessage.getReplyText());
        });

        LOG.info("Initializing Callbacks for RabbitMQ is complete");
    }

    @PostMapping(path = "/rabbitmq")
    public ResponseEntity<String> learnRabbitMq(@RequestBody DTORabbitMQRequest req){

        try {

            // Sending data
            rabbitMq.convertAndSend(
                req.getExchangeName(),
                req.getRoutingKey(),
                req.getMessageData(),
                message -> message
            );

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid Req -> " + req.toString() + " ERROR: " + e.getMessage());
        }

        return ResponseEntity.ok("Pushed!");
    }
    
    

}
