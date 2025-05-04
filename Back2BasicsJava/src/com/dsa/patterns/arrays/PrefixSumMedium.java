package com.dsa.patterns.arrays;

public class PrefixSumMedium {

    private static final int TARGET = 3;
    // private static final int[] numsList = {1, 2, 3};
    private static final int[] numsList = {1, 2, 3, 1, 1, 1};
    public static void main(String[] args) {
        bruteForce();
    }
    private static void bruteForce() {
        int numberOfOccurance = 0;
        for (int i = 0; i < numsList.length; i++) {
            int continuousSum = 0;
            for (int j = i ; j < numsList.length ; j++) {
                continuousSum += numsList[j];
                if(continuousSum == TARGET)
                    ++numberOfOccurance;
            }
        }
        System.out.println("There are total of " + numberOfOccurance + " occurances if " + TARGET);
    }
}