package com.sprlearn.learningspring.learn.concepts.datajpa.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprlearn.learningspring.learn.concepts.datajpa.entities.ProductEntity;
import com.sprlearn.learningspring.learn.concepts.datajpa.repos.ProductRepository;

@Service
public class ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepo;

    public ProductService(ProductRepository springManagedRepoObj){
        this.productRepo = springManagedRepoObj;
    }

    @Transactional(readOnly = true)
    public void tryingWithoutTransaction(){
        ProductEntity aProduct = productRepo.findAll().stream().findFirst().orElseThrow();

        log.info("Fetched: " + 
            aProduct
        );

        aProduct.setProductCurrency("USD");
    }


}
