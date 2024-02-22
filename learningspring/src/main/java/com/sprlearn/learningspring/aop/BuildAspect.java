package com.sprlearn.learningspring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BuildAspect {

    @Before("execution(* com.sprlearn.learningspring.aop.*.*(..))")
    public void beforeExecution(JoinPoint jp) {

        System.out.println("Request Received at " + jp.getTarget().getClass().getName() + " on class "
                + jp.getSignature().getName());
    }

}
