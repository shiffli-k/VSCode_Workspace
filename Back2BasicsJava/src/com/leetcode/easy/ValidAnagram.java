package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println("Result: " + isAnagram("anagram", "nagaram"));
        System.out.println("Result: " + isAnagram("rat", "car"));
        
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] aCntr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            aCntr[s.charAt(i) - 'a'] = ++aCntr[s.charAt(i) - 'a'];
            aCntr[t.charAt(i) - 'a'] = --aCntr[t.charAt(i) - 'a'];
        }

        for (int eachCount : aCntr) {
            if(eachCount > 0) return false;
        }

        return true;
    }
    public static boolean isAnagramNotGood(String s, String t) {
        Map<Character, Integer> anagramMap;
        
        if (s.length() != t.length()) {
            return false;
        }
        
        anagramMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            anagramMap.put(s.charAt(i), (anagramMap.getOrDefault(s.charAt(i),0))+1);
            anagramMap.put(t.charAt(i), (anagramMap.getOrDefault(t.charAt(i),0))-1);
        }

        for (Integer eachVal : anagramMap.values()) {
            if(eachVal != 0)
                return false;
        }
        return true;
    }

}
