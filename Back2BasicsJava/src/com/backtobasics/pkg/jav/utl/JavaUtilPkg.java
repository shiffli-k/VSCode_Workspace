package com.backtobasics.pkg.jav.utl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class JavaUtilPkg {

    public static void main(String[] args) {

        // workingWithMap();
        workingWithOptionals();

    }

    private static void workingWithOptionals() {
        Optional<String> returnedValue = Optional.empty();
        returnedValue = iMightReturnNull();

        if(returnedValue.isPresent()){
            System.out.println("Value is: " + returnedValue.get());
        } else {
            System.out.println("Value is null");
        }
    }

    private static Optional<String> iMightReturnNull(){
        String value = null;
        if(new Random().nextInt(10) % 2 == 0){
            value = "NotNull!";
        }
        return Optional.ofNullable(value);
    }

    private static void workingWithMap() {
        ConcurrentHashMap<String, String> myMap = new ConcurrentHashMap<>();
        Map<String, String> myHashMap = new LinkedHashMap<>();

        Runnable task1 = () -> {
            new JavaUtilPkg().loadingMap(myMap);
        };
        Runnable task2 = () -> {
            new JavaUtilPkg().loadingMap(myHashMap);
        };

        doMultithreading(task1);
        doMultithreading(task2);

        System.out.println("Size of the Conc Hash Map is: " + myMap.size());
        System.out.println("Size of the Norm Hash Map is: " + myHashMap.size());

    }

    private static void doMultithreading(Runnable task) {
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void loadingMap(Map<String, String> passedMap) {
        for (int i = 0; i < 100; i++) {
            passedMap.put("Key" + i, "Value" + i);
        }
    }

}
