package com.backtobasics.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExpressions {

    public static void main(String[] args) {
        // lambdaExpressionToImplementInterface();
        lambdaFunctions();
    }

    private static void lambdaFunctions() {
        
        Function<String, Void> printMessage = (passedVal) -> {
            System.out.println("The Sum is: "+passedVal);
            return null;
        };

        BiFunction<Integer, Integer, String> addByLambda = (firstVal, secondVal) -> (firstVal+secondVal)+"";
        
        
        BiFunction<Integer, Integer, Void> addByLambdaAndPrint = addByLambda.andThen(printMessage);

        addByLambdaAndPrint.apply(10, 5);


    }

    private static void lambdaExpressionToImplementInterface() {

        // Expression as a MultiLine
        LambdaTrailInterface greetUserObj = (message) -> {
            return "Hellow there "+message;
        };
        System.out.println(greetUserObj.greetUser("Dave"));

        // Expression as a SingleLine
        LambdaTrailInterface singleLineExpression = (userName) -> "Hello, "+userName;
        System.out.println(singleLineExpression.greetUser("Bob"));
    }

}
