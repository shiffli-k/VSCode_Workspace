package com.dsa.patterns.arrays;

public class TwoPointerPattern {

    static final int[] numList = { 1, 2, 4, 7, 11, 15 };
    static final int targetSum = 9999;

    public static void main(String[] args) {
        System.out.println("Position: " +
                findTarget_twoPointer()
        );
    }

    private static String findTarget_twoPointer() {
        int leftPointer = 0;
        int rightPointer = numList.length - 1;
        while (leftPointer < rightPointer) {
            if (numList[leftPointer] + numList[rightPointer] == targetSum)
                return leftPointer + " " + rightPointer;
            else if (numList[leftPointer] + numList[rightPointer] > targetSum)
                rightPointer--;
            else
                leftPointer++;
        }

        return "-1 -1";
    }
}
