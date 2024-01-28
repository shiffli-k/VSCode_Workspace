package com.backtobasics.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem 1:
Find the Square of Each Element Given a list of integers,find the square of each element.

Problem 2:
Filter Even Numbers Given a list of integers,filter out the even numbers.

Problem 3:
Find Average of a List of Doubles Given a list of double values,find the average.

Problem 4:
Convert Strings to Uppercase Given a list of strings,convert each string to uppercase.

Problem 5:
Count Strings with Length 5 Given a list of strings,count the number of strings with a length of 5.

Problem 6:
Find Maximum Element in a List Given a list of integers,find the maximum element.

Problem 7:
Group Strings by Length Given a list of strings,group them by their length.

Problem 8:
Concatenate Strings with a Separator Given a list of strings,concatenate them into a single string with a specified separator.

Problem 9:
Find Sum of Squares of Even Numbers Given a list of integers,find the sum of squares of even numbers.

Problem 10:
Remove Duplicates from a List Given a list of integers,remove duplicate elements.
*/

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);
        numbers.add(9);
        ArrayList<String> Strings = new ArrayList<>();
        Strings.add("hey");
        Strings.add("hello");
        Strings.add("this");
        Strings.add("is a String!");

        // doSquareRoot(numbers);
        // printEvenNumbers(numbers);
        // returnEvenNumber(numbers).forEach(System.out::println);
        // printStringUppercase(Strings);
        // printStringGreaterThan(Strings, 5);
        // findLargestOfIntList(numbers);
        mergingStringWithSeperator(Strings, ", ");
    }

    static void doSquareRoot(List<Integer> num) {
        num.stream()
                .map(eachNum -> eachNum * eachNum)
                .sorted()
                .forEach(System.out::println);

    }

    static void printEvenNumbers(List<Integer> num) {
        num.stream()
                .filter(eachNum -> eachNum % 2 == 0)
                .forEach(System.out::println);
    }

    static List<Integer> returnEvenNumber(List<Integer> num) {
        return num.stream()
                .filter(eachNum -> eachNum % 2 == 0)
                .collect(Collectors.toList());
    }

    static void returnAverage(List<Integer> num) {
        Double average = num.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0.0);
        System.out.println(average);
    }

    // Problem 4
    static void printStringUppercase(List<String> strArrList) {
        strArrList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // Problem 5
    static void printStringGreaterThan(List<String> inputString, int limit) {
        inputString.stream()
                .filter(eachItem -> eachItem.length() > limit)
                .forEach(eacVal -> System.out
                        .println("Exceeding Limit: " + eacVal));
    }

    // Problem 6
    static void findLargestOfIntList(List<Integer> passedList) {
        passedList.stream()
                .max(Integer::compareTo)
                .ifPresent(maxVal -> System.out.println("Max is " + maxVal));

    }

    // Problem 8
    static void mergingStringWithSeperator(List<String> passedString, String Separator) {
        passedString.stream()
                .forEach(eachStringItem -> System.out.print(eachStringItem + Separator));
    }

}
