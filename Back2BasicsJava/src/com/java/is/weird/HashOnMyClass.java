package com.java.is.weird;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HashOnMyClass {

    public static void main(String[] args) {
        /*
        Datastructures like HashMap, Hashset uses equals() and hashcode() inherited from Object class
        If unimplemented, it will lead to weird behaviour as below
        */
       theWeirdness();
    }

    private static void theWeirdness() {
        
        List<MyEmp> empList = new ArrayList<>();
        HashSet<MyEmp> empSet = new HashSet<>();
        Map<MyEmp, Integer> empSalMap = new HashMap<>();

        // Unique Emp
        MyEmp emp1 = new MyEmp(1, "emp1");
        MyEmp emp2 = new MyEmp(2, "emp2");
        
        // Duplicate employee but in different object
        MyEmp emp5 = new MyEmp(1, "emp1");
        
        System.out.println("-------------------------------------------------");

        System.out.println("Problem with List");
        empList.add(emp1);
        empList.add(emp2);
        
        // Below will only work as expected if the equals() method from Object class is overridden in MyEmp class
        if (!empList.contains(emp5)) {
            empList.add(emp5);
        }

        System.out.println(empList);

        System.out.println("-------------------------------------------------");

        System.out.println("Problem with Set and Map");
        empSet.add(emp1);
        empSet.add(emp2);
        empSet.add(emp5);
        empSalMap.put(emp1, 1000);
        empSalMap.put(emp2, 4000);
        empSalMap.put(emp5, 6000);

        System.out.println(empSet);
        System.out.println(empSalMap);

    }

}
