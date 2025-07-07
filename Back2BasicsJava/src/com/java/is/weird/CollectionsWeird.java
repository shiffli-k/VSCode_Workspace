package com.java.is.weird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionsWeird {
    public static void main(String[] args) {
        // removeList();
    }

    private static void removeList() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3,4));
        Collection<Integer> intColec = new ArrayList<>(Arrays.asList(1,2,3,4));

        // intList.remove(1);
        intList.remove(Integer.valueOf(1));
        intColec.remove(1);

    }
}
