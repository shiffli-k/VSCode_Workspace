package com.microservarch.microserviceapp.productserv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservarch.microserviceapp.productserv.model.ProductModel;

public interface ProductModelRepo extends JpaRepository<ProductModel, Long>{
}
