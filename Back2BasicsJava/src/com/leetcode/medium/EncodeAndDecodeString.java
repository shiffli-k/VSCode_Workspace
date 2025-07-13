package com.leetcode.medium;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class EncodeAndDecodeString {

    public static void main(String[] args) {
        // Input: ["we","say",":","yes"]
        // Input: ["neet","code","love","you"]

        System.out.println(
            decode(encode(Arrays.asList("we","say",":","yes")))
            + " \n" + 
            decode(encode(Arrays.asList("neet","code","love","you")))
        );


    }

    public static String encode(List<String> strs) {
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
    
    public static List<String> decode(String str) {
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
