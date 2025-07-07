package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements {
    //347. Top K Frequent Elements
    /*
        Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        
        Example 2:
        Input: nums = [1], k = 1
        Output: [1]
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,4,6,6,6,6,6,6,6};
        int k = 2;
        int[] nums1 = {1};
        int k1 = 1;
        int[] nums2 = {1,2};
        int k2 = 2;
        
        System.out.println(
            Arrays.toString(topKFrequent(nums, k))
            +" \n"+
            Arrays.toString(topKFrequent(nums1, k1))
            +" \n"+
            Arrays.toString(topKFrequent(nums1, k1))
        );
    }

    public static int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> prioQ 
            = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        int[] responseAr = new int[k];

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], 1+freqMap.getOrDefault(nums[i], 0));
        }

        prioQ.addAll(freqMap.entrySet());
        System.out.println("DEBUG: " + prioQ);

        for (int i = 0; i < k; i++) {
            responseAr[i] = prioQ.poll().getKey();
        }
        
        return responseAr;    
    }
}
