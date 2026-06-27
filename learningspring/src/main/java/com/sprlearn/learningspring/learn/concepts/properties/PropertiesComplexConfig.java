package com.sprlearn.learningspring.learn.concepts.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * The configuration class loads properties from applicationproperties to the PropertiesComplex class
 * 
 */

@Configuration
@EnableConfigurationProperties(PropertiesComplex.class)
public class PropertiesComplexConfig {
    // nothing else to mention and the annotation EnableConfigurationProperties builds it.
}
