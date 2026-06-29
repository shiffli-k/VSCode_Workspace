package com.sprlearn.learningspring.learn.concepts.errorhandling.rest;

public class IncorrectApiParameterException extends Exception{
    
    public IncorrectApiParameterException(String message){
        super(message);
    }
}
