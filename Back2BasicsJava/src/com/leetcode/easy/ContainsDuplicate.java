package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    // 217. Contains Duplicate
    public static void main(String[] args) {
        System.out.println("Contains Dupe: " 
            + containsDuplicate(new int[]{1,2,3,1}));
        System.out.println("Contains Dupe: " 
            + containsDuplicate(new int[]{1,2,3,4}));
        System.out.println("Contains Dupe: " 
            + containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> dupeSet = new HashSet<>();
        for (Integer eachItemInteger : nums) {
            if(!dupeSet.add(eachItemInteger))
                return true;
        }
        return false;
    }

    public static boolean containsDuplicateOld(int[] nums) {
        Map<Integer, Integer> dupeTracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(dupeTracker.containsKey(nums[i]))
                return true;
            else
                dupeTracker.put(nums[i], i);
        }
        return false;
    }
}
