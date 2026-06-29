package com.sprlearn.learningspring.learn.concepts.errorhandling.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.sprlearn.learningspring.learn.concepts.tryingout.rest")
public class RestControllerAdviceImpl {

    private final Logger log = LoggerFactory.getLogger(RestControllerAdviceImpl.class);

    @ExceptionHandler(exception = IncorrectApiParameterException.class)
    public ResponseEntity<ErrorResponseDTO> incorrectApiParam(IncorrectApiParameterException e){
        ErrorResponseDTO resp = new ErrorResponseDTO("01", "Invalid API Arguments", e.getMessage());
        
        return ResponseEntity.badRequest().body(resp);
    }


    // Generic Exception
    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ErrorResponseDTO> genericAllException(Exception e){
        ErrorResponseDTO resp = new ErrorResponseDTO("01", "INTERNAL Server Error", e.getMessage());
        // log.error("Exception occured: ", e);
        log.error("REST Error Captured: " + e.getMessage());
        return ResponseEntity.internalServerError().body(resp);
    }
}
