package com.backtobasics.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

        /// Basic Intermediate Operations
        // tryingOut();
        // masteringFlatMapWithAntiGravCli(); // None of these have data, so running it might fail
        // closingUpBasicOps();
        
        // Basic Terminal Ops
        terminalOps();

    }

    private static void terminalOps() {
        // 1. Check if there are any underage users (age < 18).
        // 2. Check if all users are adults (age >= 18).
        // 3. Find the age of the youngest user.
        // 4. Retrieve the first user who is older than 28.
        // 5. What is the difference between writing  .collect(Collectors.toList())  and  .toList()  at the end of a stream?

        Stream<Integer> ages = Stream.of(15, 20, 25, 30, 35);

        // int maxAge = ages.max(Integer::compareTo).orElse(0);
        // int minAge = ages.min(Integer::compareTo).orElse(0);
        ages.filter(eachItem -> eachItem)
        
        System.out.println(

        );

    }

    private static void closingUpBasicOps() {
        // 1. Prints a debug message for every single raw payment in the
        // console (e.g.,  "Processing raw: " + price ).
        // 2. Deduplicates the payment values.
        // 3. Prints a second debug message for only the unique payments that
        // remain (e.g.,  "Unique: " + price ).
        // 4. Sorts the payments in descending order (largest to smallest).
        // 5. Collects the sorted unique payments into a list.

        List<Double> rawPayments = List.of(100.0, 50.0, 100.0, 20.0, 50.0);

        System.out.println(
            rawPayments.stream()
                    .peek(eachPrice -> System.out.println("Processing: " + eachPrice))
                    .distinct()
                    .peek(eachUniquePrice -> System.out.println("Unique: " + eachUniquePrice))
                    .sorted(Comparator.reverseOrder())
                    .peek(eachSorted -> System.out.println("Sorted: " + eachSorted))
                    .collect(Collectors.toList())
        );


    }

    private static void masteringFlatMapWithAntiGravCli() {
        List<List<Integer>> numGrps = List.of(
            List.of(1,2,3),
            List.of(4,5),
            List.of(6,7,8,9,10)
        );
        
        System.out.println(
            numGrps.stream() //Stream<List<Integer>>>
                .map(List::stream)
                // .flatMap(List::stream) //Unbox each List<Integer> to a Stream<Integer>
                .collect(Collectors.toList()) // Turns Stream<Integer> to List<Integer>
        );

        printLine();

        List<Usr> usrList = List.of(
            new Usr("N1", "1e1", "1e2", "1e3"),
            new Usr("N2", "2e1", "2e2"),
            new Usr("N3", "3e1", "3e2", "3e3", "3e4")
        );

        System.out.println(
            usrList.stream()
                    .flatMap(eacItem -> eacItem.getuEmails().stream())
                    .collect(Collectors.toList())
        );

        printLine();

        // 1. Extracts all the  LineItem  objects from all orders.
        // 2. Filters to keep only items that cost more than $50.00.
        // 3. Extracts the product names from those remaining items.
        // 4. Returns a unique, alphabetically sorted list of those product names.

        List<Order> ordLst = new ArrayList<>();
        ordLst.add(new Order());

        System.out.println(
            ordLst.stream()
                .flatMap(eachOrder -> eachOrder.getLineItems().stream())
                .filter(eachLineItem -> eachLineItem.getPrice() > 50.0D)
                .map(LineItem::getProductName)
                .distinct()
                .sorted()
                .collect(Collectors.toList())
        );

        printLine();


        /*   Write a stream pipeline starting with a
        List<Department> departments  that:

        1. Traverses all courses across all departments.
        2. Filters to keep only courses that are active.
        3. Traverses all students enrolled in those active
        courses.
        4. Extracts the names of those students.
        5. Returns a unique, alphabetically sorted list of
        student names. */
        List<Department> depList = new ArrayList<>();
        depList.stream()
                .flatMap(eachdep -> eachdep.getCourses().stream())
                .filter(eachCourse -> eachCourse.isActive())
                .flatMap(eachCourse -> eachCourse.getEnrolledStudents().stream())
                .map(Student::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        
        printLine();
        /*
            Starting with a  List<Employee> employees , you want to extract all
            bios that are present.
            • The Catch: Since  getProfile()  and  getBio()  return  Optional
            objects, how do you flatten them into a single  Stream<String>  of
            bios, filtering out any missing/empty values without using manual
            null checks or  .isPresent() ?
            
            Hint: In Java 9+,  Optional  has a  .stream()  method which returns
            a stream of either 0 or 1 element. You can flat-map an  Optional
            into a stream!
         */
        List<com.backtobasics.java8.Employee> emp = new ArrayList<>();
        emp.add(new Employee("n1", new Profile("Bio1")));
        emp.add(new Employee("n2", new Profile("Bio2")));
        
        emp.stream()
                .map(eachEmp -> eachEmp.getProfile())
                .filter(Optional::isPresent)
                .map(eachPresentProf -> eachPresentProf.get().getBio())
                .filter(Optional::isPresent)
                .map(eachPresentBio -> eachPresentBio.get())
                .collect(Collectors.toList());
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
                .map(eachVal -> eachVal * 10)
                .map(Double::intValue)
                // .sorted(Comparator.reverseOrder())
                .sorted(Integer::compareTo)
                .sorted(Comparator.comparing(Function.identity(), Integer::compareTo))
                .forEach(System.out::println);

        printLine();

        int[] myar = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> evnList = Arrays.stream(myar)
                .filter(eachVal -> eachVal % 2 == 0)
                .map(eachVal -> eachVal * 10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(evnList);

        printLine();

        List<Usr> usrList = List.of(
                new Usr("N1", "1e1", "1e2", "1e3"),
                new Usr("N2", "2e1", "2e2"),
                new Usr("N3", "3e1", "3e2", "3e3", "3e4"));

        // The wrong way
        List<List<String>> emailList = usrList.stream()
                .map(eachUser -> eachUser.getuEmails())
                .collect(Collectors.toList());
        System.out.println(emailList);

        printLine();

        // The right way!
        List<String> emailListFlat = usrList.stream()
                .flatMap(eachUsr -> eachUsr.getuEmails().stream())
                .collect(Collectors.toList());
        System.out.println(emailListFlat);

        printLine();

        List<String> sentences = Arrays.asList("Hello world", "JavaStreams are fun");

        
        System.out.println(
            sentences.stream()
                    .map(eachItem -> Arrays.stream(eachItem.split(" ")))
                    // .flatMap(eachItem -> Arrays.stream(eachItem.split(" ")))
                    .collect(Collectors.toList())
        );

    }

    private static boolean mRef_Modulo(int a) {
        return a % 2 == 0;
    }

    private static void printLine() {
        System.out.println("----------");
    }

}


