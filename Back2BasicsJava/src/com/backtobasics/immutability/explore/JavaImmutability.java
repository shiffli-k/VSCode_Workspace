package com.backtobasics.immutability.explore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaImmutability {

    public static void main(String[] args) {
        // tryingOutImmutability();
        immutabilityProblem2();
    }

    /**
     * 
     * Showcase on how passing in a Object reference could infect/unintionally modify other objects
     * 
     */
    private static void immutabilityProblem2() {
        List<String> basicCourseList = new ArrayList<>(Arrays.asList("Java", "C", "Python"));
    
            // If I want to show off my Stream API Skills
            // Stream.of("Java", "C", "Python")
            // .collect(Collectors.toCollection(ArrayList::new));

        Student s1 = new Student(0, "s1", basicCourseList);

        // Infected/Modified S1's course list even before assigning to to S2
        basicCourseList.add("MATHS"); 

        Student s2 = new Student(1, "s2", basicCourseList);

        System.out.println(
            s1+"\n"+s2
        );

    }

    /**
     * 
     * Showcase on how Encapsulation breaks when using Objects due to Java's 'Java is call by value but the value is reference' logic
     * 
     */
    private static void tryingOutImmutability() {
        Student s1 = new Student(0, "S1", "Java", "Python", "C");

        int a = s1.getStdID();
        ++a;

        String b = s1.getStdName();
        b.toLowerCase();

        // The getStdCourseList() unintentionally shares the object reference thereby breaking encapsulation.
        List<String> c = s1.getStdCourseList();
        c.add("!!!!MATH!!!!");


        System.out.println(s1);

    }


}
