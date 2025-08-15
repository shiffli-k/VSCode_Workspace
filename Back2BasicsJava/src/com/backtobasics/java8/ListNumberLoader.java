package com.backtobasics.java8;

import java.util.List;
import java.util.Random;

public class ListNumberLoader {
    private static Random rnd = new Random();
    public static void loadRandomNumbers(List<Integer> theListToLoad, int loadSize){
        for (int i = 0; i < loadSize; i++) {
            theListToLoad.add(rnd.nextInt(1,20));
        }
        System.out.println("List loaded: " + theListToLoad);
        return;
    }
}
