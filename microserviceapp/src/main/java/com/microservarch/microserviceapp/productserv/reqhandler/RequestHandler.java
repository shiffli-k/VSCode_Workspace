package com.microservarch.microserviceapp.productserv.reqhandler;

import org.springframework.web.bind.annotation.RestController;

import com.microservarch.microserviceapp.productserv.model.ProductModel;
import com.microservarch.microserviceapp.productserv.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class RequestHandler {

    @Autowired private ProductService productServ;

    @GetMapping("/")
    public String baseRequestHandler() {
        return "Hello World! Spring Boot w/ Gradle :) ";
    }

    @GetMapping("/products/all")
    public ResponseEntity<List<ProductModel>> returnAllProductsString() {
        return ResponseEntity.ok().body(productServ.listAllProducts());
    }

    @PostMapping("/products/add")
    public ResponseEntity<String> addAProducString(@RequestBody ProductModel requestProduct) {
        return ResponseEntity.ok().body(productServ.addProduct(requestProduct));
    }
}
