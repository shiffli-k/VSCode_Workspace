package com.dsa.algorithms;

import java.util.Random;

import com.software.design.patterns.observer.MessageFeed.contentType;

public class Sorting {

    private static int[] myAr = loadArrayWithElem(10);

    public static void main(String[] args) {
        printArray(myAr);
        sortArrayBubbleSort(myAr);
        printArray(myAr);
    }

    private static void sortArrayBubbleSort(int[] arrayToSort) {
        int updatedLength = arrayToSort.length;
        for (int iteration = 0; iteration < arrayToSort.length; iteration++) {

            for (int currentElement = 0; currentElement < updatedLength; currentElement++) {

                if(currentElement+1 >= updatedLength)
                    continue;

                if(arrayToSort[currentElement] > arrayToSort[currentElement+1]){
                    int mem = arrayToSort[currentElement];
                    arrayToSort[currentElement] = arrayToSort[currentElement+1];
                    arrayToSort[currentElement+1] = mem;
                }
                
            }
            --updatedLength;

        }
        return;
    }

    private static int[] loadArrayWithElem(int loadSize) {
        int[] arrayToLoad = new int[loadSize];

        for (int i = 0; i < arrayToLoad.length; i++) {
            arrayToLoad[i] = new Random().nextInt(0, 100);
        }

        return arrayToLoad;
    }

    private static void printArray(int[] arrayToPrint) {
        System.out.println("------Printing Elements in Array------");
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.println("\n------Printing Elements in Array | END------");
        return;
    }

}
