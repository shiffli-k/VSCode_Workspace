package com.learn.microservice.servicea.api.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientApiService {

    public static enum API_CLIENT {JAVA, SPRING_LEGACY, SPRING_LATEST, SPRING_CLOUD_OPEN_FEIGN};

    private final Logger log = LoggerFactory.getLogger(ClientApiService.class);

    public static final String API_URL = "http://localhost:8002/";

    private FeignClient4ServiceB feignClient;

    public ClientApiService(FeignClient4ServiceB springFeignClient4ServiceB){
        this.feignClient = springFeignClient4ServiceB;
    }

    public String getResponseFromServiceB(API_CLIENT apiType) {
        return switch (apiType) {
            case JAVA -> getResponseJava();
            case SPRING_LEGACY -> getResponseSpringLegacy();
            case SPRING_LATEST -> getResponseSpringLatest();
            case SPRING_CLOUD_OPEN_FEIGN -> this.feignClient.getResponseBasePathFeign();
            default -> "InvalidArgument";
        };
    }

    /**
     * 
     * Modern Spring way, uses similar builder pattern like modern Java's HTTPClient
     * 
     * @return
     */
    private String getResponseSpringLatest(){
        String apiResponse = "No Reponse";
        RestClient api = RestClient.create(API_URL);
        apiResponse = api.get().retrieve().body(String.class);
        return apiResponse;
    }

    /**
     * 
     * Legacy Spring way, A great alternatice to HTTPURLCOnnection.
     * 
     * @return
     */
    private String getResponseSpringLegacy(){
        String apiResponse = "No Reponse";
        RestTemplate api = new RestTemplate();

        try {
            apiResponse = api.getForObject(API_URL, String.class);
        } catch (Exception e) {
            log.error("Exception getting response using SpringLegacy", e);
            apiResponse = e.getMessage();
        }
        return apiResponse; 
    }

    
    /**
     * Building A API Client using Core Java
     * 
     * @return The response from the service B
     * 
     */
    private String getResponseJava(){

        String response = "No Response from ClientB";

        try {

            HttpClient apiCall = HttpClient.newHttpClient();

            HttpRequest apiReq = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(API_URL))
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
