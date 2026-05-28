package com.backtobasics.java8.testingstream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamVsNormal {
    public static void main(String[] args) {
        doProcess();
        
    }

    private static void doProcess() {
        List<Integer> dupeList = loadDuplicates(100000);
        
        usingGoodOlJava(dupeList);
        usingStreamAPI(dupeList);
    }

    private static void usingStreamAPI(List<Integer> passedList) {
        Instant curTime = Instant.now();
        Map<Integer, Long> dupeMap = passedList.stream().collect(
            Collectors.groupingBy(eachElem -> eachElem, Collectors.counting())
        );
        
        List<Integer> uniqueList = dupeMap.keySet().stream()
        .filter(eachKey -> dupeMap.get(eachKey) <= 1)
        .collect(Collectors.toList());
        
        System.out.println("S:Unique Items: " + uniqueList.size());
        System.out.println("ProcessingTime: " +
            Duration.between(curTime, Instant.now()).toMillis()
        );

        return;
    }

    private static void usingGoodOlJava(List<Integer> sharedList) {
        Instant curTime = Instant.now();
        Map<Integer, Integer> dupeMap = new HashMap<>();
        List<Integer> uniqueItems = new ArrayList<>();

        for(Integer eachItem : sharedList){
            int currentCount = dupeMap.getOrDefault(eachItem, 0);
            dupeMap.put(eachItem, ++currentCount);
        }

        for(Integer eachKey : dupeMap.keySet()){
            if (dupeMap.get(eachKey) <= 1) {
                uniqueItems.add(eachKey);
            }
        }

        System.out.println("J:Unique Items: " + uniqueItems.size());
        System.out.println("ProcessingTime: " +
            Duration.between(curTime, Instant.now()).toMillis()
        );

        return;
    }

    private static List<Integer> loadDuplicates(int loadSize) {
        List<Integer> loadedList = new ArrayList<>(loadSize);
        Random rng = new Random();

        for (int i = 1; i <= loadSize; i++) {
            loadedList.add(rng.nextInt(0, loadSize));
        }

        return loadedList;
    }
}
