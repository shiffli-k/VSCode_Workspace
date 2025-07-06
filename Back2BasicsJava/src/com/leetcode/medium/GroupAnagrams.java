package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    //49. Group Anagrams
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        String[] strs1 = new String[] {""};
        String[] strs2 = new String[] {"a"};
        
        // Below Boi failed on me :'(
        String[] strs3 = new String[] {"eat","tea","tan","ate","nat","bat","ac","bd","aac","bbd","aacc","bbdd","acc","bdd"};
        // Expected Output:
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(
            groupAnagrams(strs)
            +" \n" +
            groupAnagrams(strs1)
            +" \n" +
            groupAnagrams(strs2)
            +" \n" +
            groupAnagrams(strs3)
            // +" \n EXPECTED IS " +"[[\"bdd\"],[\"bat\"],[\"nat\",\"tan\"],[\"ac\"],[\"ate\",\"eat\",\"tea\"],[\"bd\"],[\"aac\"],[\"bbd\"],[\"aacc\"],[\"bbdd\"],[\"acc\"]]"
        );
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length < 2) {
            List<List<String>> obj2 = new ArrayList<>();
            obj2.add(Arrays.asList(strs));
            return obj2;
        }

        Map<String, List<String>> consoliList = new HashMap<>();
        for (String currentString : strs) {
            int[] curArMap = generateCounterArr(currentString);
            String curKey = generateKeyForArMap(curArMap);
            System.out.println("Debug: Key for " + currentString + " is: " + curKey);

            List<String> currentConsoliListKey = consoliList.getOrDefault(curKey, new ArrayList<>());
            currentConsoliListKey.add(currentString);

            consoliList.put(curKey, currentConsoliListKey);
        }

        List<List<String>> resultingList = new ArrayList<>();
        
        consoliList.values().forEach(eachValue -> {
            resultingList.add(eachValue);
        });

        return resultingList;
    }

    private static String generateKeyForArMap(int[] curArMap) {
        StringBuilder keyString = new StringBuilder();
        for (int i = 0; i < curArMap.length; i++) {
            if(curArMap[i] > 0){
                //Char+Count
                // ('a'+i)+curArMap[i]
                keyString.append(Character.toString('a' + i)+curArMap[i]);
            }
        }
        return keyString.toString();
    }

    private static int[] generateCounterArr(String currentString) {
        int[] alphabetCounter = new int[26];
        for (char currentChar : currentString.toCharArray()) {
            alphabetCounter[currentChar - 'a'] = ++alphabetCounter[currentChar - 'a'];
        }
        return alphabetCounter;
    }

}
