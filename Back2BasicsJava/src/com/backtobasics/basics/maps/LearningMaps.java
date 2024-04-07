package com.backtobasics.basics.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LearningMaps {
    public static void main(String[] args) {
        // aHashMap();
        linkedAccessMaps();
    }
    
    private static void linkedAccessMaps() {
        Map<Integer, String> accessMap = new LinkedHashMap<>(10, 0.75F, true);
        accessMap.put(1, "Val1");
        accessMap.put(2, "Val2");
        accessMap.put(3, "Val3");
        accessMap.put(4, "Val4");
        accessMap.put(5, "Val5");
        accessMap.put(6, "Val6");
        accessMap.put(7, "Val7");
        accessMap.put(8, "Val8");
        accessMap.put(9, "Val9");
        
        System.out.println("Access Enabled - Pre Access: "+accessMap);
        
        accessMap.get(4);
        accessMap.get(4);
        accessMap.get(4);
        accessMap.get(4);
        accessMap.get(4);
        accessMap.get(3);
        accessMap.get(3);
        accessMap.get(3);
        
        System.out.println("Access Enabled - Pos Access: "+accessMap);
        
        Map<Integer, String> nonAccessMap = new LinkedHashMap<>(10, 0.75F, false);
        nonAccessMap.put(1, "Val1");
        nonAccessMap.put(2, "Val2");
        nonAccessMap.put(3, "Val3");
        nonAccessMap.put(4, "Val4");
        nonAccessMap.put(5, "Val5");
        nonAccessMap.put(6, "Val6");
        nonAccessMap.put(7, "Val7");
        nonAccessMap.put(8, "Val8");
        nonAccessMap.put(9, "Val9");
        
        System.out.println("Access Disabled - Pre Access: "+nonAccessMap);
        nonAccessMap.get(4);
        nonAccessMap.get(4);
        nonAccessMap.get(4);
        nonAccessMap.get(4);
        nonAccessMap.get(4);
        nonAccessMap.get(3);
        nonAccessMap.get(3);
        nonAccessMap.get(3);

        System.out.println("Access Disabled - Pos Access: "+nonAccessMap);
        
        
    }
    
    private static void aHashMap(){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("Key1", "Val1");
        myMap.put("Key2", "Val2");
        myMap.put("Key3", "Val3");
        myMap.put("Key4", "Val4");
        printMap(myMap);
    }



    private static <k, v> void printMap(Map<k, v> passedMap){
        System.out.println("-----Printing Map-----");
        passedMap.forEach((t, u) -> {
            System.out.println(t +" "+ u);
        });
        System.out.println("-----Printing Map Completed-----");
    }
    
    private static <k,v> void printKeySet(Map<k, v> passedMap){

        System.out.println("-----Printing Key List-----");
        System.out.println("KeySet"+passedMap.keySet());
        System.out.println("-----Printing Key List Complete-----");
        
    }
}
