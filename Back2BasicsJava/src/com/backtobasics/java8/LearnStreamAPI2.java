package com.backtobasics.java8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class LearnStreamAPI2 {
    private static List<Integer> myList = new ArrayList<>();
    static {
        myList.add(71);
        myList.add(24);
        myList.add(43);
        myList.add(96);
        myList.add(11);
    }

    public static void main(String[] args) {
        try1();
        Vector<String> obj = new Stack<>();
        Deque<String> obj1 = new ArrayDeque<>();
        
    }

    private static void try1() {
        System.out.println("Try 1 - Print Even Numbers");

        // Using Stream
        myList.stream()
        .filter(eachNumber -> eachNumber % 2 == 0)
        .forEach(System.out::println);

        // Normal Way
        for(Integer eachElem : myList)
            if(eachElem % 2 == 0)
                System.out.println(eachElem);
    }
}
