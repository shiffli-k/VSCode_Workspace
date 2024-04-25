package com.backtobasics.java8;

public interface LambdaTrailInterface {

    /**
     * 
     * Sample interface which has a template of printMessage. Will try to use Lambda Expression to implement this interface.
     * 
     * @param messageToPrint - Pass a message which needs to be printed.
     * 
     */
    // public void printMessage(String messageToPrint);


    /**
     * 
     * @param userName - User name is passed
     * @return A string saying a Greeting with the passed username.
     * 
    */
    public String greetUser(String userName);
    
}
