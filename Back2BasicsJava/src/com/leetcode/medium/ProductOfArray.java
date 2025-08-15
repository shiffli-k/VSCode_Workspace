package com.leetcode.medium;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] tc1 = {1,2,3,4};
        System.out.println(
            Arrays.toString(
                new ProductOfArray().productExceptSelf_naiveWay(tc1)
            )
        );
    }

    public int[] productExceptSelf_naiveWay(int[] nums) {
        int[] resultingProdArr = new int[nums.length];
        int currentSum = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(j==i)
                    continue;
                currentSum *= nums[j]; 
            }
            resultingProdArr[i] = currentSum;
            currentSum = 1;
        }
        return resultingProdArr;   
    }
}
