package com.backtobasics.java8;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Learning stream API once and for all!
 */
public class StreamAPI_v2 {
    public static void main(String[] args) {
        tryingOut();

    }

    // The backbone of Stream APIs

    // Take <T> and return boolean
    private Predicate<Integer> genericInput_BooleanOutput = eachVal -> eachVal % 2 == 0;
    private BiPredicate<Integer, Integer> generic2Input_BooleanOutput = (a, b) -> a.equals(b);

    // Take <T> and return <R>
    private Function<String, String> genericInput_geneticOutput = eachVal -> eachVal.toUpperCase();
    private BiFunction<String, String, String> genericInput2_geneticOutput = (eachVal1,
            eachVal2) -> eachVal1.toUpperCase() + eachVal2.toUpperCase();

    // Take <T> return void
    private Consumer<String> genericInput_voidOutput = eachVal -> System.out.println(eachVal);
    private BiConsumer<String, String> generic2Input_voidOutput = (valA, valB) -> System.out.println(valA + valB);

    // Take none, return <R>
    private Supplier<String> voidInput_StringOutput = () -> "Supplier";

    // The backbone of Stream APIs | END

    private static void tryingOut() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            // .filter(eachVal -> eachVal % 2 == 0)
            .filter(StreamAPI_v2::mRef_Modulo) // Using same as above with method reference operator
            .map(eachVal -> eachVal + eachVal)
            .forEach(System.out::println);
        printLine();
        Stream.generate(Math::random)
            .limit(10)
            .map(eachVal -> eachVal*10)
            .map(Double::intValue)
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
    }

    private static boolean mRef_Modulo(int a) {
        return a % 2 == 0;
    }

    private static void printLine(){
        System.out.println("----------");
    }

}
