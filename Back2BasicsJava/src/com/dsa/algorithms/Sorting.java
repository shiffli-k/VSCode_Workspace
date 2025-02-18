package com.dsa.algorithms;

import java.util.Random;

public class Sorting {

    private static int[] myAr = loadArrayWithElem(10);

    public static void main(String[] args) {
        myAr[0]=99;
        printArray(myAr);
        // sortArrayBubbleSort(myAr);
        // sortArraySelectionSort(myAr); 
        sortArrayInsertionSort(myAr);
        printArray(myAr);
    }

    private static void sortArrayInsertionSort(int[] arry) {

        for (int i = 1; i < arry.length; i++) {
            int currentValue = arry[i];
            int indexToCompare = i-1;

            while (indexToCompare >= 0 && arry[indexToCompare] > currentValue) {
                arry[indexToCompare+1] = arry[indexToCompare];
                --indexToCompare;
            }

            arry[indexToCompare + 1] = currentValue;

        }

    }

    private static void sortArraySelectionSort(int[] theArray) {
        int lowestIndex = 0;
        int memory;
        boolean isLowerElemFound = false;

        for (int pass = 0; pass < theArray.length; pass++) {
            for (int currentIndex = pass; currentIndex < theArray.length; currentIndex++) {
                if (theArray[currentIndex] < theArray[lowestIndex]) {
                    lowestIndex = currentIndex;
                    isLowerElemFound = true;
                }
            }

            if (isLowerElemFound) {
                memory = theArray[lowestIndex];
                theArray[lowestIndex] = theArray[pass];
                theArray[pass] = memory;
                lowestIndex = pass;
                isLowerElemFound = false;
            }
            lowestIndex = pass + 1;
        }
    }

    private static void sortArrayBubbleSort(int[] arrayToSort) {
        int updatedLength = arrayToSort.length;
        for (int iteration = 0; iteration < arrayToSort.length; iteration++) {

            for (int currentElement = 0; currentElement < updatedLength; currentElement++) {

                if (currentElement + 1 >= updatedLength)
                    continue;

                if (arrayToSort[currentElement] > arrayToSort[currentElement + 1]) {
                    int mem = arrayToSort[currentElement];
                    arrayToSort[currentElement] = arrayToSort[currentElement + 1];
                    arrayToSort[currentElement + 1] = mem;
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
