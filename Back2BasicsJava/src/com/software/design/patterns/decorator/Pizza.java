package com.software.design.patterns.decorator;

public interface Pizza {

    public enum sizes{
        LARGE, MEDIUM, SMALL
    }

    public String getDetails();
    public void bakePizza(); 

}
