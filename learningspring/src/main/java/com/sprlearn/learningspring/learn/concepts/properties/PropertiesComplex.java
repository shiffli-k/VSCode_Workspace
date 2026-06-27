package com.sprlearn.learningspring.learn.concepts.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;

/**
 * 
 * The Properties are loaded here.
 * 
 * The record here could not be directly used as spring doesnt load values automatically. A configuration class is required to load the values.
 * 
 */
@ConfigurationProperties(prefix = "complex.myapp")
@Validated
public record PropertiesComplex(
        @NotBlank String prop1,
        String prop2,
        String prop3
    ){}
