package com.backtobasics.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WorkingWithOptionals {
    public static void main(String[] args) {
    
        Map<String, String> objMap = new HashMap<>();

        Optional<String> value = Optional.ofNullable(objMap.get("InvalidKey"));

        System.out.println(
            value.orElse("Value not in map")
            );
            
        }
}
