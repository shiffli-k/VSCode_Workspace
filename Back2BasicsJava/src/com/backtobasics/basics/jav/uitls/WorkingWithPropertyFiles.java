package com.backtobasics.basics.jav.uitls;

public class WorkingWithPropertyFiles {
    public static void main(String[] args) {
        PropertyManager.myConfigProperties.forEach((key, val) -> {
            System.out.println(key + " : " + val);
        });
    }
}
