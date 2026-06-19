package com.backtobasics.nxtlevel;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextLevel {
    
    public static void main(String[] args) {
        // day15June26("racecar", "malayalam", "test", "notAPalindromeWord");
        // day15June26_Simple("racecar", "malayalam", "test", "notAPalindromeWord");
        day16June26();


    }
    
    private static void day16June26() {

        getCharCount("ThisIsAWord");
        getAnagram("gnaaram", "anagram");
        getAnagram("yes", "noo");
        

    }

    private static void getAnagram(String firstString, String secondString) {
        
        final int charAId = 97;
        
        if (Integer.compare(firstString.length(), secondString.length()) != 0) {
            System.out.println("Not anagram | since they are of different length");
        }

        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();

        int[] charMap = new int[26];

        for (int i = 0; i < firstString.length(); i++) {
            int firstChar = firstString.charAt(i);
            int secondChar = secondString.charAt(i);

            ++charMap[firstChar-charAId];
            --charMap[secondChar-charAId];

        }

        for (int eachVal : charMap) {
            if(eachVal != 0){
                System.out.println("Not an Anagram");
                return ;
            }
        }

        System.out.println("They are anagram!");

        return;

    }

    private static void getCharCount(String theWordToReturnCountFor) {
        
        theWordToReturnCountFor = theWordToReturnCountFor.toLowerCase();

        final int charAId = 97;
        final int[] charMap = new int[26];

        for (int i = 0; i < theWordToReturnCountFor.length(); i++) {
            int currentChar = theWordToReturnCountFor.charAt(i);
            int mapIndex = currentChar - charAId;
            
            ++charMap[mapIndex];

        }

        for (int i = 0; i < charMap.length; i++) {
            if(charMap[i] != 0){
                System.out.println((char)(i+charAId) + " count is " + charMap[i]);
            }
        }


    }

    private static void day15June26_Simple(String... words) {
        for (String eachWord : words) {
            if(eachWord.toLowerCase().equals(new StringBuilder(eachWord.toLowerCase()).reverse().toString()))
                System.out.println(eachWord + " are in pallindrom.");
            else
                System.out.println(eachWord + " are not in pallindrom.");
        }
    }

    private static void day15June26(String... words) {

        Arrays.stream(words)
        .collect(
            Collectors.toMap(
                word -> word.toLowerCase(),
                word -> new StringBuilder(word).reverse().toString().toLowerCase(),
                (existingKey, incomingKey) -> existingKey // Duplicate Key handling
            )
        ).forEach((originalString ,reversedString) -> {
            if(originalString.equals(reversedString))
                System.out.println(originalString + " & " + reversedString + " are in pallindrom.");
            else
                System.out.println(originalString + " & " + reversedString + " are not in pallindrom.");
            });
        
    }

    //----------------------------

}
