package com.backtobasics.basics.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LearnVector {

    public static void main(String[] args) {

        int size = 1000000;

        List<Integer> arList = new ArrayList<>();
        List<Integer> vecList = new Vector<>();

        // Loading ArrayList
        long stateTimeMillis = System.currentTimeMillis();
        for (int iterator = 0; iterator < size; iterator++) {
            arList.add(1);
        }
        System.out.println("Process Time for ArrayList: " + (System.currentTimeMillis() - stateTimeMillis));

        // Loading Vector
        stateTimeMillis = System.currentTimeMillis();
        for (int iterator = 0; iterator < size; iterator++) {
            vecList.add(1);
        }
        System.out.println("Process Time for VectorList: " + (System.currentTimeMillis() - stateTimeMillis));

    }

}
