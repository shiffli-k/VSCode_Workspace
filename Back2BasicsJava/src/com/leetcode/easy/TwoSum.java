package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // 1. Two Sum
    // The Legend!
    public static void main(String[] args) {
        
        System.out.println(
            "Index: " + 
            Arrays.toString(twoSum(new int[] {2,7,11,15}, 9))
        );
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tracker = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(tracker.containsKey(diff))
                return new int[] {tracker.get(diff), i};
            tracker.put(nums[i], i);
        }

        return null;
    }
}
