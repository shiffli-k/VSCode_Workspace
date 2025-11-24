package com.java.is.weird;

public class Wrappers {

    // Java Wrappers arent as great as they seem :D

    public static void main(String[] args) {
        theEqualsProblem();
        unboxthis();        
    }

    private static void unboxthis() {
        System.out.println("------ Unboxing Bomb ------");
        int a = 1;
        Integer b = 2;
        a = b; // Unboxed!
        System.out.println("Boom, Unboxed it! " + a);

        b=null;
        try {
            a = b;
        } catch (Exception e) {
            System.out.println("Boom, Unboxed with a explotion " + a + " | Exception: " + e.getMessage());
        }


    }

    private static void theEqualsProblem() {
        System.out.println("------ Equals Problem ------");
        Integer a = 127;
        Integer b = 127;
        System.out.println((a==b) + " They are Equals");
        a=128;
        b=128;
        System.out.println((a==b) + " Not cashing them, so not equal!");
        
    }

}
