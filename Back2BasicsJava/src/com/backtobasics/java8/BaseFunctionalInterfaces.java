package com.backtobasics.java8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BaseFunctionalInterfaces {

    private static String message = "Hello from Functional Interface";

    public static void main(String[] args) {

        myOwnFunctionalInterfaces();
        functionalInterfacesByJava();
    }

    private static void functionalInterfacesByJava() {

        // Pass single argument and a return type
        Function<String, Integer> returnLength = passedString -> passedString.length();
        System.out.println("Lenght of '" + message + "' is " + returnLength.apply(message));

        // Pass single Argument but a fixed boolean return type
        Predicate<String> checkNull = passedString -> passedString == null;
        System.out.println("Positive: " + checkNull.test(message) + " | Negative: " + checkNull.test(null));

        // Pass single Argument but returns Void
        Consumer<String> printVal = passedString -> System.out.println("PassedString is: " + passedString);
        // Consumer<String> printVal = System.out::println;
        printVal.accept(message);

        // Pass no Argument but returns any Data type
        Supplier<String> greet = () -> "Hello from Supplier";
        System.out.println("Message from Supplier: " + greet.get());

        // Both Argument and Return type are the same
        UnaryOperator<String> greetHello = userName -> "Hello there " + userName + ", Pleased to meet you!";
        System.out.println("Msg from UnaryOp: " + greetHello.apply("John"));

        // Same as Unary but can take Two param and a return type but all being of same
        // data type
        BinaryOperator<String> greetHelloFstLst = (firstName, lastName) -> "Hello there " + firstName + " " + lastName
                + ", Pleased to meet you!";
        System.out.println("Msg from BinaryOp: " + greetHelloFstLst.apply("Jonathan", "Wick"));

        // Other Function Extension - BiFunction, TriFunction
        BiFunction<String, String, Boolean> obj = null;
    }

    private static void myOwnFunctionalInterfaces() {
        CustomFunctionalInterface intFace = passedArg -> System.out.println(passedArg);
        intFace.execute(message);
    }

}
