package com.sprlearn.learningspring.learn.concepts.datajpa.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprlearn.learningspring.learn.concepts.datajpa.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID>{
    
}
