package com.dsa.algorithms.searching;

import java.util.Arrays;
import java.util.Random;

public class MyBinarySearch {
    // Implement a binary search \ Show prime who is boss!
    public static void main(String[] args) {
        int[] myArr = null;
        
        myArr=loadArrayWithSize(10);

        System.out.println(
            "Loaded Array:" + Arrays.toString(myArr)
        );
        
        Arrays.sort(myArr);
        
        System.out.println(
            "Sorted Array:" + Arrays.toString(myArr)
        );

        int lookForValue = myArr[new Random().nextInt(9)];
        System.out.println("Searching for value: " + lookForValue);
        binarySearchArray(myArr, lookForValue);

        binarySearchArray(myArr, 99999);
        
    }

    private static void binarySearchArray(int[] myArr, int elementToFind) {
        int elementFoundAtIndex = binSearchRecurc(myArr, 0, myArr.length-1, elementToFind);
        System.out.println(
            "Element found at Index " + elementFoundAtIndex
        );
    }

    private static int binSearchRecurc(int[] myArr, int startIndex, int endIndex, int elementToFind) {
        if(startIndex > endIndex)
            return -1;
            
        int midIndex = (startIndex + endIndex)/2;
        if (elementToFind == myArr[midIndex]) {
            return midIndex;
        }
        if (elementToFind > myArr[midIndex]) {
            return binSearchRecurc(myArr, midIndex+1, endIndex, elementToFind);
        }
        if (elementToFind < myArr[midIndex]) {
            return binSearchRecurc(myArr, startIndex, midIndex-1, elementToFind);
        }
        return -1;
    }

    private static int[] loadArrayWithSize(int limit) {
        int[] resultingArray = new int[limit];
        Random rng = new Random();
        for (int iterator = 0; iterator < limit ; iterator++){
            resultingArray[iterator] = rng.nextInt(0, 1000);
        }
        return resultingArray;
    }
}
 