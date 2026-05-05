package com.backtobasics.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WorkingWithOptionals {
    public static void main(String[] args) {
        // predefinedMethods();
        // myOwnMethods();

        theProblem();
    }

    private static void predefinedMethods() {
        Map<String,String> keyMap = new HashMap<>();
        keyMap.put("Key1", "Value1");

        // String valueFetched = keyMap.get("Key2");

        Optional<String> valueOpt = Optional.ofNullable(keyMap.get("Key2"));

        // Using - Testing if they are equal
        String theStringValue = valueOpt.orElse("UnknownValue");

        System.out.println(
            theStringValue.equals("Value1")
        );

    }

    private static void theProblem(){
        // The traditional Methods
        // System.out.println("JD of Alex is: " + getJD_bad("Alex").toUpperCase());
        // System.out.println("JD of Barry is: " + getJD_bad("Barry").toUpperCase());
        
        // The Java 8 - Optional Way
        
        System.out.println("JD of Alex is: " + getJD("Alex").orElse("User Not in DB").toUpperCase());
        System.out.println("JD of Barry is: " + getJD("Barry").orElse("User Not in DB").toUpperCase());
    }

    private static String getJD_bad(String nameOfPerson){
        String theJobDescription = null;

        // Some Business Logic - Complex
        if("Alex".equals(nameOfPerson))
            theJobDescription="Software Engineer";
        // Some Business Logic END

        return theJobDescription;
    }
    private static Optional<String> getJD(String nameOfPerson){
        Optional<String> theJD = Optional.empty();

        // Some Business Logic - Complex
        if("Alex".equals(nameOfPerson))
            theJD=Optional.of("software engineer");
        // Some Business Logic END

        return theJD;
        // return null; // Soo its kinda defeats the point of Optional :(
    }

    private static void myOwnMethods() {
        
    }
}
