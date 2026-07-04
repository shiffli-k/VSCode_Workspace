package com.sprlearn.learningspring.learn.concepts.tryingout.learningunittests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyDepdendentClass {

    private final Logger LOG = LoggerFactory.getLogger(MyDepdendentClass.class);

    public boolean isEven_Dependent(int valToCheck){
        LOG.info("Checking if" + valToCheck + " is even");
        return valToCheck % 2 ==0;
    }

}
