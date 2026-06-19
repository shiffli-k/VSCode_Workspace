package com.sprlearn.learningspring.app.filterinterceptors;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyAppFilter implements Filter{

    private static final Logger log = LoggerFactory.getLogger(MyAppFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        
        // log.info("Intercepted for Filer - Started");
        // System.out.println("Filtered");
        chain.doFilter(req, resp);
        // log.info("Intercepted for Filer - Completed");
        
    }

}
