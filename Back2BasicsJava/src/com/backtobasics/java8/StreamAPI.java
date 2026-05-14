package com.backtobasics.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tried to learn but couldnt understand it properly I guess
 */
public class StreamAPI {

    public static void main(String[] args) {
        someBasicStream();
    }

    private static void someBasicStream() {
        List<Integer> arLst = new ArrayList<>();
        ListNumberLoader.loadRandomNumbers(arLst, 20);

        System.out.println(
            arLst.stream() // TheSource! [Producer]
                
                // [Intermediate]
                .filter(eachElem -> eachElem % 2 ==0)
                // .peek(eachElem -> System.out.println("Val: " + eachElem))
                .distinct()
                // .peek(eachElem -> System.out.println("Val Dist: " + eachElem))
                .sorted(Comparator.reverseOrder())

                // Consumer / Collectors
                // .count()

                // The Consumer / Collector
                .collect(Collectors.toList())
        );
        
        prntLine();

        System.out.println(
            "1: Filter & Collect \n" +
            arLst.stream()
            .filter(curNum -> curNum > 10)
            .distinct()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList())
        );

        prntLine();

        System.out.println(
            "2. Map & Sorted \n" +
            Stream.of("Zendaya", "Bob", "Alice", "James", "Jonathan", "Wick", "Aaron")
            // .map(eachItem -> eachItem.toUpperCase())
            .map(String::toUpperCase)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList())
        );

        prntLine();
        // arLst = new ArrayList<>(); // Emptying it
        System.out.println(
            "3. Reduce(SUM & MAX) \n" + 
            "\n Doing sum " +
            arLst.stream()
            // .reduce(0, (a,b) -> a+b)
            .reduce(Integer::sum).orElse(-1)
            
            + "\n Doing Max " +
            arLst.stream()
            // .reduce(0, (a,b) -> {
            //     if(a>b)
            //         return a;
            //     else
            //         return b;
            // })
            .reduce(Integer::max).get()

        );
    }
    
    private static void prntLine(){
        System.out.println("-------------------");
    }
}
