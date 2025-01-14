package com.dsa.array;

import java.util.Random;

public class MyArray {

    private static final int ARRAY_SIZE = 11;
    public static int[] theArray = new int[ARRAY_SIZE];

    public static void main(String[] args) {
        // loadArrayWithRndValues(10);
        // printArray();
        // better_insertbyShiftingNewArray(69, 3);
        // deleteElementAndShift(3);
        // printArray();
        basicChallengeWithArray();
    }

    private static void basicChallengeWithArray() {

        loadArrayWithRndValues(ARRAY_SIZE);
        printArray();
        reverseArrayAndMaxMin();
        printArray();

    }

    private static void reverseArrayAndMaxMin() {
        // For Array Reversing
        int memory=0;
        int reverse_i=0;
        
        // For MaxMin
        int maximunVal = Integer.MIN_VALUE;
        int minumumVal = Integer.MAX_VALUE;

        for (int i = 0; i < theArray.length; i++) {
            reverse_i = theArray.length-i-1;
            if(i>=(reverse_i))
                break;

            if(theArray[i]>maximunVal)
                maximunVal=theArray[i];
            if(theArray[reverse_i]>maximunVal)
                maximunVal=theArray[reverse_i];

            if(theArray[i]<minumumVal)
                minumumVal=theArray[i];
            if(theArray[reverse_i]<minumumVal)
                minumumVal=theArray[reverse_i];

            memory = theArray[i];
            theArray[i]=theArray[reverse_i];
            theArray[reverse_i]=memory;
        }

        System.out.println("Max is: "+maximunVal+" Min is: "+minumumVal);
    }

    private static void deleteElementAndShift(int indexToDelete) {
        for (int i = indexToDelete; i < theArray.length - 1; i++) {
            theArray[i] = theArray[i + 1];
        }
        theArray[theArray.length - 1] = 0;
    }

    // Try System.arrayCopy
    public static void better_insertbyShiftingNewArray(int valueToInsert, int indexToInsert) {
        int sizeOfNewArray = theArray.length + 1;
        int[] newWorkingArray = new int[sizeOfNewArray];

        System.arraycopy(theArray, 0, newWorkingArray, 0, indexToInsert);
        newWorkingArray[indexToInsert] = valueToInsert;
        System.arraycopy(theArray, indexToInsert, newWorkingArray, indexToInsert + 1,
                theArray.length - indexToInsert - 1);

        theArray = newWorkingArray;

        return;
    }

    public static void insertByShifting(int valueToInsert, int indexToInsert) {
        for (int i = theArray.length - 1; i >= indexToInsert; i--) {
            theArray[i] = theArray[i - 1];
        }
        theArray[indexToInsert] = valueToInsert;
        return;
    }

    public static void insertByShiftingNewArray(int valueToInsert, int indexToInsert) {
        int sizeOfNewArray = theArray.length + 1;
        int[] newWorkingArray = new int[sizeOfNewArray];
        for (int i = 0, j = 0; i < theArray.length; i++, j++) {
            if (j == indexToInsert) {
                newWorkingArray[j] = valueToInsert;
                i--;
                continue;
            }
            newWorkingArray[j] = theArray[i];
        }
        theArray = newWorkingArray;
        return;
    }

    public static void loadArrayWithRndValues(int limit) {
        for (int i = 0; i < theArray.length && i <= limit - 1; i++) {
            theArray[i] = new Random().nextInt(1, 100);
        }
    }

    public static void printArray() {
        System.out.println("--PrintingArray--");
        for (int eachinteger : theArray) {
            System.out.print(eachinteger + " ");
        }
        System.out.println("\n--PrintingArray | Completed--");
    }
}
