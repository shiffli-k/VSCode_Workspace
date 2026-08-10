package com.learn.microservice.servicea.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// @FeignClient(name = "serviceb-client", url = ClientApiService.API_URL)
@FeignClient(name = "MYDISCOVERABLESERVICE")
public interface FeignClient4ServiceB {

    @GetMapping(path = "/")
    public String getResponseBasePathFeign();
}
