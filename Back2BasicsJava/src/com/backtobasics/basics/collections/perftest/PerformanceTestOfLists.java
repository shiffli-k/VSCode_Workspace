package com.backtobasics.basics.collections.perftest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class PerformanceTestOfLists {

    private static Vector<Integer> vector = new Vector<>();
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static LinkedList<Integer> linkedList = new LinkedList<>();
    private static final int LOAD_COUNT = 1000000;

    public static void main(String[] args) {
        singleThreadedTest();
    }

    private static void singleThreadedTest() {

        System.out.println("Loadtest of " + LOAD_COUNT + " elements");
        loadListWithCount(vector, LOAD_COUNT);
        loadListWithCount(arrayList, LOAD_COUNT);
        loadListWithCount(linkedList, LOAD_COUNT);

        System.out.println("Travese of " + LOAD_COUNT + " elements");
        traverseListLinear(vector);
        traverseListLinear(arrayList);
        traverseListLinear(linkedList);

        System.out.println("Remove of first element");
        removeFirstElement(vector);
        removeFirstElement(arrayList);
        removeFirstElement(linkedList);

        System.out.println("Remove of mid element");
        removeMidElement(vector);
        removeMidElement(arrayList);
        removeMidElement(linkedList);

        int elemToFind = new Random().nextInt(0, LOAD_COUNT);
        System.out.println("Finding Element/Number: " + elemToFind);
        getIndexOfRandomElem(vector, elemToFind);
        getIndexOfRandomElem(arrayList, elemToFind);
        getIndexOfRandomElem(linkedList, elemToFind);
    }

    private static void getIndexOfRandomElem(List<Integer> passedList, int elemToFind) {
        Instant startTime = Instant.now();
        System.out.println("Integer "+elemToFind+" found at index: "+passedList.indexOf(elemToFind));
        System.out.println("\t Time taken for " + passedList.getClass() + " is "
                + Duration.between(startTime, Instant.now()).toMillis() + " ms");
    }
    private static void removeFirstElement(List<Integer> passedList){
        Instant startTime = Instant.now();
        passedList.remove(1);
        System.out.println("\t Time taken for " + passedList.getClass() + " is "
                + Duration.between(startTime, Instant.now()).toMillis() + " ms");
    }
    private static void removeMidElement(List<Integer> passedList){
        Instant startTime = Instant.now();
        passedList.remove(LOAD_COUNT/2);
        System.out.println("\t Time taken for " + passedList.getClass() + " is "
                + Duration.between(startTime, Instant.now()).toMillis() + " ms");
    }

    private static void traverseListLinear(List<Integer> passedList) {
        Instant startTime = Instant.now();
        for (Integer eachElem : passedList) {
            if (eachElem % 100000 == 0)
                System.out.println("\t\tAt elem: " + eachElem + " elapsed time: "
                        + Duration.between(startTime, Instant.now()).toMillis() + " ms");
        }
        System.out.println("\t Time taken for " + passedList.getClass() + " is "
                + Duration.between(startTime, Instant.now()).toMillis() + " ms");
    }

    private static void loadListWithCount(List<Integer> passedList, int numberOfelemToLoad) {
        Instant startTime = Instant.now();
        for (int i = 0; i < numberOfelemToLoad; i++) {
            passedList.add(i);
        }
        System.out.println("\t Time taken for " + passedList.getClass() + " is "
                + Duration.between(startTime, Instant.now()).toMillis() + " ms");
    }
}
