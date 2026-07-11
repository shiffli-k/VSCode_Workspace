package com.learn.microservice.servicea.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.microservice.servicea.api.service.ClientApiService;

@RestController
public class ServiceARestController {

    private final Logger log = LoggerFactory.getLogger(ServiceARestController.class);

    private ClientApiService javaRestClient;

    public ServiceARestController(ClientApiService springObjJavaRestClientService){
        this.javaRestClient = springObjJavaRestClientService;
    }
    
    @GetMapping(path = "/")
    public ResponseEntity<String> basePath(){
        StringBuilder responseMessage = new StringBuilder("Hello and welcome from Service A \n");
        
        // responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.JAVA));
        // responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.SPRING_LEGACY));
        // responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.SPRING_LATEST));
        responseMessage.append(javaRestClient.getResponseFromServiceB(ClientApiService.API_CLIENT.SPRING_CLOUD_OPEN_FEIGN));

        return ResponseEntity.ok(responseMessage.toString());
    }

}
