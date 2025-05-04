package com.dsa.patterns.arrays;

import java.util.Arrays;

public class PrefixSum {

    private static final int[] listOfNums = {5, 1, 3, 2, 6};
    private static int[] preFixSumOf_listOfNums;

    public static void main(String[] args) {
        loadPrefixSum();
        System.out.println("Items in OrgArr: " + Arrays.toString(listOfNums));
        System.out.println("Items in PreFix: " + Arrays.toString(preFixSumOf_listOfNums));
        // getSumOf(2, 4);

    }
    
    private static void getSumOf(int startIndex, int endIndex) {
        int sumValue; 
        if(startIndex>0)
           sumValue = (preFixSumOf_listOfNums[endIndex] - preFixSumOf_listOfNums[startIndex-1]);
        else
           sumValue = (preFixSumOf_listOfNums[endIndex]);

        System.out.println("Sum of Index starting at: " + startIndex + " and ending Index: " + endIndex + " = " + sumValue);
    }

    private static void loadPrefixSum() {
        preFixSumOf_listOfNums = new int[listOfNums.length];
        int cummulativeSum = 0;
        for (int i = 0; i < listOfNums.length; i++) {
            cummulativeSum += listOfNums[i];
            preFixSumOf_listOfNums[i] = cummulativeSum;
        }
    }

}