package com.microservarch.microserviceapp.productserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservarch.microserviceapp.productserv.model.ProductModel;
import com.microservarch.microserviceapp.productserv.repo.ProductModelRepo;

@Service
public class ProductService {
    @Autowired private ProductModelRepo prodDb;
    
    public List<ProductModel> listAllProducts(){
        return prodDb.findAll();
    }

    public String addProduct(ProductModel productToInsert){
        prodDb.save(productToInsert);
        return "Product Added Successfully";
    }
}
