package com.dsa.patterns.hshmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashFrequencyMap {
    public static void main(String[] args) {
        System.out.println("FirstNonRepeatingChar: "
                + firstNonRepeatingCharacter("aabbbbKKnwwv"));

        System.out.println("---- WarmUp - Majority Elements ----");
        int[] numsArr = { 2, 2, 1, 1, 2, 2, 3 };
        findMajrotiyInArray(numsArr);

        System.out.println("---- Isomorphic Strings ----");
        System.out.println("Are they isomorphic? egg & add: " + isIsomorphic("egg", "add"));
        System.out.println("Are they isomorphic? foo & bar: " + isIsomorphic("foo", "bar"));

        System.out.println("---- Intersection of Arrays ----");
        int[] lst1 = { 10, 6, 1, 2, 3, 9 };
        int[] lst2 = { 9, 6, 1, 2, 5 };
        System.out.println("Elements Intersecting array are: " + intersectArrays(lst1, lst2));

        System.out.println("---- Longest Sequence in Array ----");
        int[] unSortedArray = {5, 100, 4, 200, 1, 3, 2 };
        System.out.println("The array has: " + Arrays.toString(unSortedArray));
        System.out.println("The longest sequence: " + longestSequenceOfArray(unSortedArray));
        
        System.out.println("---- Two Sum feat. HashMap ----");
        int[] numsList = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Array: " + Arrays.toString(numsList) + " Target " + target);
        System.out.println("Index that sums to target: " + twoSumHashMap(numsList, target));


    }

    private static String twoSumHashMap(int[] numsList, int target) {
        Map<Integer, Integer> neededMap = new HashMap<>();

        for (int i = 0; i < numsList.length; i++) {
            int neededVal =target - numsList[i];
            if(neededMap.containsKey(neededVal))
                return "[ " + i + ", " + neededMap.get(neededVal) + " ]";
            else
                neededMap.put(numsList[i], i);
        }

        return null;
    }

    private static String longestSequenceOfArray(int[] unSortedArray) {
        Set<Integer> intSet = new HashSet<>();
        int freqCounter = 0;
        for(int eachElem : unSortedArray){
            intSet.add(eachElem);
        }

        for(int eachElem : unSortedArray){
            if(intSet.contains(eachElem-1)){
                ++freqCounter;
            }
        }

        if(freqCounter != 0)
            return Integer.toString(freqCounter+1);

        return Integer.toString(freqCounter);
    }

    private static List<Integer> intersectArrays(int[] lst1, int[] lst2) {
        Set<Integer> lst1Map = new HashSet<>();
        Set<Integer> lst2Map = new HashSet<>();
        List<Integer> intersectingItems = new ArrayList<>();

        for (int eachElement : lst1)
            lst1Map.add(eachElement);
        for (int eachElement : lst2)
            lst2Map.add(eachElement);

        for (Integer eachElemInMap1 : lst1Map) {
            if (lst2Map.contains(eachElemInMap1)) {
                intersectingItems.add(eachElemInMap1);
            }
        }
        return intersectingItems;
    }

    private static boolean isIsomorphic(String firstString, String lastString) {
        Map<Character, Character> fstLstMap = new HashMap<>();
        Map<Character, Character> lstFstMap = new HashMap<>();

        for (int i = 0; i < firstString.length(); i++) {
            fstLstMap.put(firstString.charAt(i), lastString.charAt(i));
            lstFstMap.put(lastString.charAt(i), firstString.charAt(i));
        }
        if (fstLstMap.size() == lstFstMap.size())
            return true;
        else
            return false;

    }

    private static void findMajrotiyInArray(int[] passedArray) {
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        int keyWithMajority = Integer.MIN_VALUE;
        int valWithMajority = Integer.MIN_VALUE;

        for (Integer eachInteger : passedArray) {
            freqMap.put(eachInteger, (freqMap.getOrDefault(eachInteger, 0)) + 1);
        }

        System.out.println("KeyMap: " + freqMap);

        for (Map.Entry<Integer, Integer> eachEntry : freqMap.entrySet()) {
            if (valWithMajority < eachEntry.getValue()) {
                valWithMajority = eachEntry.getValue();
                keyWithMajority = eachEntry.getKey();
            }
        }

        System.out.println("Integer " + keyWithMajority + " has the most dupes of count " + valWithMajority);

    }

    private static char firstNonRepeatingCharacter(String passedValue) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        char firstOccuredChar = '0';
        for (char eachChar : passedValue.toCharArray())
            freqMap.put(eachChar, (freqMap.getOrDefault(eachChar, 0)) + 1);
        System.out.println("Map: " + freqMap);

        for (Map.Entry<Character, Integer> eachEntry : freqMap.entrySet()) {
            if (eachEntry.getValue() == 1)
                return eachEntry.getKey();
        }
        return firstOccuredChar;
    }
}
