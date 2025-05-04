package com.dsa.patterns.arrays;

import java.time.Instant;
import java.util.Arrays;

public class SlidingWindowSubarray {

    // The requirement
    // Input: arr = [2, 1, 5, 1, 3, 2], k = 3  
    // Output: 9  
    // Explanation: Subarray [5,1,3] has the maximum sum = 9

    private static final int[] arr = {2, 1, 5, 1, 3, 2};
    private static final int width = 4;
    private static final int expectedOutput = 9;

    public static void main(String[] args) {

        debLog("---- The Nweb Way----");
        theNaiveWay();
        debLog("---- The (e)Leet Code Way----");
        theLeetCodeWaySlidingWindow();

    }

    private static void theLeetCodeWaySlidingWindow() {
        debLog("Watch, imma about slide through this array like I slide into her DM's");
        
        debLog("Working with Array "+ Arrays.toString(arr));

        int maxValue = Integer.MIN_VALUE;
        int cumulator = 0;

        int windowStartIndex=0;
        int windowEndIndex=1;

        cumulator = arr[windowStartIndex];

        while (windowEndIndex < arr.length) {

            if((windowEndIndex - windowStartIndex) <width){
                cumulator+=arr[windowEndIndex];
                ++windowEndIndex;
                continue;
            }
            
            if((windowEndIndex - windowStartIndex) == width){
                cumulator -= arr[windowStartIndex];
                cumulator += arr[windowEndIndex];
                ++windowEndIndex;
                ++windowStartIndex;
                maxValue = Math.max(cumulator, maxValue);
                continue;
            }
            
        }

        debLog("So umm, the max val is " + maxValue);
        System.out.println("I slid me windows and low and behold, the max value is " +  maxValue);

    }

    private static void theNaiveWay() {
        int maxValue = Integer.MIN_VALUE;
        int positionOfMaxVal = -1;
        debLog("Ahh Sheeeet, here we go again. Please dont Array");
        for (int i = 0; i < arr.length; i++) {
            debLog("Start Pos: " + i);
            int currentBatchSum = 0;
            for (int j = i; j < i+width && j < arr.length ; j++) {
                debLog("\tSumming " + j + " with value " + arr[j]);
                currentBatchSum+=arr[j];
                debLog("\tSummed as " + currentBatchSum);
            }
            // maxValue = Math.max(maxValue, currentBatchSum);
            if(currentBatchSum > maxValue){
                positionOfMaxVal = i;
                maxValue = currentBatchSum;
            }
            debLog("\t Current Max is "+maxValue);
        }

        System.out.println("--Processed Successfully--");
        System.out.println("Max Value is: "+maxValue);
        System.out.println("Values that make up the max values" + Arrays.toString(new int[]{arr[positionOfMaxVal],arr[positionOfMaxVal+1],arr[positionOfMaxVal+2] }));

        if(maxValue == expectedOutput)
            System.out.println("Bada BING! Bada BOOM!"); 

    }

    private static void debLog(String message){
        System.out.println(Instant.now()+" | "+message);
    }

}
