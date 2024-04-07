package com.backtobasics.basics.collections;

import java.util.ArrayList;

public class CollectionsJava {
    public static void main(String[] args) {
        // arrayList();
    }

    static void arrayList() {
        ArrayList<String> carBrand = new ArrayList<String>();
        ArrayList<String> germanCarBrand = new ArrayList<String>();
        germanCarBrand.add("Audi");
        germanCarBrand.add("BMW");
        germanCarBrand.add("Mercedes");
        germanCarBrand.add("VW");
        germanCarBrand.add("Porsche");
        carBrand.addAll(germanCarBrand);
        carBrand.add("Ferrari");
        carBrand.add("Rolls Royce");

        if (carBrand.containsAll(germanCarBrand))
            System.out.println("CarBrand contains German Cars");

        // germanCarBrand = new ArrayList<>(germanCarBrand.reversed());
        // germanCarBrand.reversed().forEach(item -> {
        //     System.out.println(item);
        // });
    }
}
