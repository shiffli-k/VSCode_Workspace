package com.leetcode.medium;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class EncodeAndDecodeString {

    // LeetCode 271| Encode and Decode String

    public static void main(String[] args) {
        // Input: ["we","say",":","yes"]
        // Input: ["neet","code","love","you"]
        System.out.println("------------");
        System.out.println(
            "The (This could work on any language) way" + 
            decode(encode(Arrays.asList("we","say",":","yes")))
            + " \n" + 
            decode(encode(Arrays.asList("neet","code","love","you")))
        );

        // System.out.println(
        //     "The Java Serialization way!" + 
        //     decodeSerialize(encodeSerialize(Arrays.asList("we","say",":","yes")))
        //     + " \n" + 
        //     decodeSerialize(encodeSerialize(Arrays.asList("neet","code","love","you")))
        // );

        
    }
    
    
    public static List<String> decode(String str) {

        if(str.length() < 1)
            return Arrays.asList("");

        List<String> resultingArList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            if('#' == currentChar && i+1 < str.length()){
                StringBuilder resultingWord = new StringBuilder();
                char followingChar = str.charAt(i+1);
                int expectedLength = Integer.parseInt(followingChar+"");

                for(int j = 0 ; j < expectedLength ; j++){
                    resultingWord.append(str.charAt(j+i+2));
                }
                i += expectedLength - 1;
                resultingArList.add(resultingWord.toString());
            }

        }

        return resultingArList;
    }

    public static String encode(List<String> strs) {
        if(strs.size() < 1)
            return "";
        StringBuilder encodedVal = new StringBuilder();
        for(String eachItem : strs)
            encodedVal.append("#" + eachItem.length() + eachItem);
        System.out.println("Encoded of " + strs + " is " + encodedVal.toString());
        return encodedVal.toString();
    }

    public static String encodeSerialize(List<String> strs) {
        try {
            ByteArrayOutputStream bros = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bros);
            oos.writeObject(strs);
            return Base64.getEncoder().encodeToString(bros.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<String> decodeSerialize(String str) {
        try {
            ByteArrayInputStream bris = new ByteArrayInputStream(Base64.getDecoder().decode(str));
            ObjectInputStream bis = new ObjectInputStream(bris);
            return (List<String>) bis.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
