package com.sprlearn.learningspring.learn.concepts.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesSimple {

    // Getting ApplicationProperties
    private final String fooString;
    private final int fooInteger;
    private final boolean fooBoolean;

    public PropertiesSimple(
        @Value("${myapp.prop.fooString:defaultString}") String fooStringValue,
        @Value("${myapp.prop.fooInteger:-1}") int fooIntegerValue,
        @Value("${myapp.prop.fooBoolean:false}") boolean fooBooleanValue
    ){
        this.fooString = fooStringValue;
        this.fooInteger = fooIntegerValue;
        this.fooBoolean = fooBooleanValue;
    }

    @Override
    public String toString() {
        return "Values are: PropertiesSimple [fooString=" + fooString + ", fooInteger=" + fooInteger + ", fooBoolean=" + fooBoolean
                + "]";
    }

}
