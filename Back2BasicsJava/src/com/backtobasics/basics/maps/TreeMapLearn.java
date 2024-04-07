package com.backtobasics.basics.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class TreeMapLearn {
    public static void main(String[] args) {
        // tryingHashMap();
        tryingTreeMap();
    }

    private static void tryingTreeMap() {
        Map<String, String> treMap = new TreeMap<>();
        addElementstoMap(treMap, 10);
        printMap(treMap);
    }

    private static void tryingHashMap(){
        Map<String, String> hashMp = new HashMap<>();
        addElementstoMap(hashMp, 20);
        
        // printMap(hashMp);

        // System.out.println(
        //     hashMp.containsKey("Key6")+" "+
        //     hashMp.containsValue("Value10")
        // );

        System.out.println("KeySet: "+hashMp.keySet());
        System.out.println("Values: "+hashMp.values());
        System.out.println("EntitySet : "+hashMp.entrySet());

    }









    /**
     * Just to add elements
     * @param passedMap Pass any Integer - String map
     * */
    @SuppressWarnings("unused")
    private static void addElementstoMap(Map<String, String> passedMap, Integer limit){
        IntStream.range(1, limit).forEach( val -> {
            passedMap.put("Key"+val, "Value"+val);
        });
    }

    /**
     * Just to print elements
     * @param passedMap pass any Map
     * */
    @SuppressWarnings("unused")
    private static <K, V> void printMap(Map<K, V> passedMap){
        System.out.println("--Printing Map--");
        passedMap.forEach((pK, pV) -> {
            System.out.println("    "+pK+" | "+pV);
        });
        System.out.println("--Printing Map | Complete--");
    }

    private static void print(Object passedVal){
        System.out.println(passedVal);
    }

}
