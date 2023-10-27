package com.backtobasics.basics;

public class fundamentals {
    public static void main(String[] args) {
        // ArraysWoah();
        // prntTillZero(5);

        // System.out.println("Recursion 1: " + reverseString("WOAH RECURSION"));
        // System.out.println("Recursion 2: " + reverseString("KAYAK"));
        // System.out.println(isPalindrome("kayak"));

        stringCompare();
    }

    public static void primitives() {
        // byte byteVal = 127;
        // byteVal = -127;
        // short shortVal = 32767;
        // shortVal = -32767;
        // int intVal = 1;
        // long longInt = 123;
        // float floatVal = 1.0F;
        // double doubleVal = 1.0;
        // boolean isBoolean = true;
        // char aChar = 'E';
    }

    public static void casting() {
        float aFloat = 1.000f;
        int aInt = 0;
        aInt = (int) aFloat;
        System.out.println(aInt);
        aInt = 125;
        aFloat = aInt;
        System.out.println(aFloat);

    }

    public static void StringMethods() {
        String stringLiteral = "Hello";
        String stringLiteral1 = "Hello";
        String stringObject = new String("Hello");
        // Never Compare String like this Very bad
        // System.out.println(stringLiteral == stringObject);
        stringLiteral.equals(stringObject);
        String stringObject1 = new String("Hello");
        System.out.println(stringObject == stringObject1);
        System.out.println(stringLiteral == stringLiteral1);

    }

    public static void MathRand() {
        // 50 - 150
        System.out.println((int) (Math.random() * 101) + 50);
    }

    public static void ArraysWoah() {

        // Using System.ArrayCopy
        String[] main_array = { "Hey", "There", ",Hello!" };
        String[] copiedArray = { "A", "B", "C" };
        System.arraycopy(main_array, 0, copiedArray, 0, main_array.length);
        for (String eachArrayItem : copiedArray) {
            System.out.println(eachArrayItem);
        }

    }

    // Recursion
    public static int prntTillZero(int startValue) {
        if (startValue <= 0) {
            return 0;
        } else {
            System.out.print(startValue + " ");
            return prntTillZero(--startValue);
        }
    }

    // Recursion
    public static String reverseString(String UserPassedString) {
        if (UserPassedString == null || UserPassedString.length() <= 1)
            return UserPassedString;
        else
            return (UserPassedString.charAt(UserPassedString.length() - 1) +
                    reverseString(UserPassedString.substring(1, UserPassedString.length() - 1)) +
                    UserPassedString.charAt(0));
    }

    public static boolean isPalindrome(String checkString) {
        return checkString.equals(reverseString(checkString));
    }

    static void stringCompare() {
        String a = "hello";
        String b = "hello";

        String as = new String("hello");
        String bs = new String("hello");

        System.out.println(a == b);
        System.out.println(as == bs);
        System.out.println(as.equals(bs));

    }
}
