package com.learn.microservice.servicea.api.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceARestController {

    private final Logger log = LoggerFactory.getLogger(ServiceARestController.class);
    
    @GetMapping(path = "/")
    public ResponseEntity<String> basePath(){
        StringBuilder responseMessage = new StringBuilder("Hello and welcome from Service A \n");
        responseMessage.append(getResponseFromServiceB());
        return ResponseEntity.ok(responseMessage.toString());
    }

    private String getResponseFromServiceB() {
        String response = "No Response from ClientB";
        try {
            HttpClient apiCall = HttpClient.newHttpClient();
            HttpRequest apiReq = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8002/"))
                .build();
            HttpResponse<String> apiRespnse = apiCall.send(apiReq, HttpResponse.BodyHandlers.ofString());

            response = "ServiceB Responded with " + apiRespnse.statusCode() + " with Data: " + apiRespnse.body();

        } catch (InterruptedException | IOException e) {
            log.error("Error gettign response from Service B", e);
            response = "Error getting response " + e.getMessage();
        }

        return response;
    }
}
