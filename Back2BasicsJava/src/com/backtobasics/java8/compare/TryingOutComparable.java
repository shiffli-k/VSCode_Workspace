package com.backtobasics.java8.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TryingOutComparable {
    public static void main(String[] args) {
        // exploringWaysToCompareTwoObjects();
        // usingComparatorAndComparable();
    }
    
    private static void usingComparatorAndComparable() {
        List<Employee> empList = loadRandomEmployeesWithDupe(10);
        printEmpList(empList);
        Collections.sort(empList, Comparator.reverseOrder());
        printEmpList(empList);
        return;
    }

    private static void exploringWaysToCompareTwoObjects() {
        boolean similarity;

        Employee emp1 = new Employee(1, "Employee1");
        Employee emp2 = new Employee(2, "Employee2");
        Employee emp3 = new Employee(2, "Employee2");

        // Comparing two objects
        
        // 1. The wrong way - Only compares objects
        similarity = (emp2 == emp3);

        // 2. Know what to compare
        similarity = (emp2.getEmp_id() == emp3.getEmp_id());

        // 3. Emp Class Method via Object reference
        similarity = emp3.isEquals(emp2);

        // 4. Emp Class Util method | Pass in two objects
        similarity = Employee.isBothEqual(emp2, emp3);

        // 5. Enforced with Comparable
        similarity = (emp2.compareTo(emp3) == 0) ? true : false;
        
        System.out.println("Similarity result of two Objects: " + (similarity ? "They are Same" : "They are Unique!"));

    }

    private static List<Employee> loadRandomEmployeesWithDupe(int loadSize){
        List<Employee> empList = new ArrayList<>(loadSize);
        Random rng = new Random();
        for (int i = 0; i < loadSize; i++) {
            int rngVal = rng.nextInt(loadSize/2);
            empList.add(
                new Employee(rngVal, "Employee"+rngVal)
            );
        }
        return empList;
    }

    private static void printEmpList(List<Employee> empList){
        for (Employee eachEmp : empList) {
            System.out.println(" " + eachEmp.getEmp_id());
        }
        System.out.println("-----------");
        return;
    }
}
