package com.sprlearn.learningspring.learn.concepts.errorhandling.rest;

public class ErrorResponseDTO {
    private final String errorCode;
    private final String errorMessage;
    private final String errorDescription;

    public ErrorResponseDTO(String code, String message, String description){
        this.errorCode = code;
        this.errorMessage = message;
        this.errorDescription = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    
}
