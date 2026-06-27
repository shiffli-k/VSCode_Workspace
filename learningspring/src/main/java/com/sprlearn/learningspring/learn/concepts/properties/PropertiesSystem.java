package com.sprlearn.learningspring.learn.concepts.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesSystem {
    private final String OS_NAME;
    private final String JAVA_VERSION;
    private final String INVALID_SYSTEM_PROP;

    public PropertiesSystem(
        @Value("#{systemProperties['java.version']}") String osName,
        @Value("#{systemProperties['os.namee']}") String javaVersion,
        @Value("#{systemProperties['doesnt.exist'] ?: 'NotFound'}") String invalidProperty
    ){
        this.OS_NAME = osName;
        this.JAVA_VERSION = javaVersion;
        this.INVALID_SYSTEM_PROP = invalidProperty;
    }

    @Override
    public String toString() {
        return "Values in PropertiesSystem are [OS_NAME=" + OS_NAME + ", JAVA_VERSION=" + JAVA_VERSION + ", INVALID_SYSTEM_PROP="
                + INVALID_SYSTEM_PROP + "]";
    }

    
}
