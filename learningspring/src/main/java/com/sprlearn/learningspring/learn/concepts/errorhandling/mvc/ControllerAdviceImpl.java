package com.sprlearn.learningspring.learn.concepts.errorhandling.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.sprlearn.learningspring.learn.concepts.tryingout.mvc")
public class ControllerAdviceImpl {

    private final Logger log = LoggerFactory.getLogger(ControllerAdviceImpl.class);

    @ExceptionHandler(exception = GenericMVCException.class)
    public String handleGenericMVCExceptions(GenericMVCException e, Model mvc){
        
        mvc.addAttribute("errorHeader", "⚠︎ A Generic Exception has occured");
        mvc.addAttribute("errorDescription", e.getMessage());

        return "error/genericErrorPage";
    }

    @ExceptionHandler(exception = Exception.class)
    public String handleAllExceptions(Exception e, Model mvc){

        log.error("MVC Error captured: " + e.getMessage());

        mvc.addAttribute("errorHeader", "An unexpected error has occured");
        mvc.addAttribute("errorDescription", e.getMessage());

        return "error/genericErrorPage";
    }
}
