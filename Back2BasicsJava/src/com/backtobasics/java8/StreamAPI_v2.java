package com.backtobasics.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.software.design.patterns.factory.DrawStructureFactory.useStructure;

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
        // terminalOps();

        // Primitive Streams
        // learningPrimitiveStreams();
        // testingPrimitiveStreams();

        // Streams returning Optional
        // exploringOptionalsInStream();

        // Collectors
        exploringCollectors();
        // additionalChallenges();

    }

    private static void additionalChallenges() {
        /*
        Challenge 1: The ID Indexer (Map Collision Prevention)
        Scenario: You are loading a list of Product entities from a database cache to build an in-memory index. However, because of a legacy data bug, some products might share the exact same productId.
        Your Goal: Collect a Stream<Product> into a Map<String, Product>, where the key is the productId. If a duplicate ID shows up, keep the product that has the higher price.
        Hint: You need the 3-argument version of Collectors.toMap(). Your merge function lambda will need to compare prod1.getPrice() and prod2.getPrice().
        */
        Stream<Product> prodStream = Stream.of(
            new Product("n1", "c1", 100),
            new Product("n1", "c1", 200),
            new Product("n2", "c1", 100)
        );

        System.out.println(
            prodStream.collect(
                Collectors.toMap(Product::name, Function.identity(), (existing, incoming) ->existing.price() >= incoming.price() ? existing : incoming)
            )
        );

        /*
        Challenge 2: The E-Commerce Split (Partitioning)
        
        Scenario: You have a stream of Order objects. Each order has a method isPremiumCustomer() (returns a boolean) and getInvoiceAmount() (returns an integer).
        
        Your Goal: You need to split the orders into two buckets: Premium customers vs Regular customers. But instead of getting their full order history, your manager only wants to see the total sum of invoice amounts for each group.
        Expected Output Structure: Map<Boolean, Integer>
        
        Hint: Use Collectors.partitioningBy(). For the second argument (the downstream collector), don't pass the default—use the numeric collector we talked about for summing values up.
        */
        Stream.of(
            new OrdersChal("u1", false, 100),
            new OrdersChal("u1", false, 200),
            new OrdersChal("u2", true, 100),
            new OrdersChal("u2", true, 200),
            new OrdersChal("u2", true, 300)
        )
        .collect(Collectors.partitioningBy(
            OrdersChal::isPremiumCustomer
            ,
            Collectors.summingInt(OrdersChal::invoiceAmt)
            )
        ).forEach((key, val) -> {
            if(key) System.out.println("Premium customers spent: " + val);
            else System.out.println("NonPremium customer spent: " + val);
        });


        /*
        Challenge 3: Redacting the "Syllabus" (The Rematch!)

        Scenario: Let's conquer that nesting fear. You have a list of Ticket objects for a tech support system. Each ticket has a getCategory() (e.g., "Hardware", "Software") and a getPriority() (e.g., "LOW", "HIGH", "CRITICAL").

        Your Goal: Group the tickets by their category. But for the map's value, you don't want a list of entire ticket objects; you only want a Set<String> of the unique priority levels present in that category.
        Expected Output Structure: Map<String, Set<String>>

        Hint: This is structured exactly like the employee department problem. Use Collectors.groupingBy() as your base, and nest a Collectors.mapping() inside it to extract the priority strings into a Collectors.toSet().
        */

        Stream.of(
            new Tickets("1", "HARDWARE", "LOW"),
            new Tickets("2", "HARDWARE", "LOW"),
            new Tickets("3", "SOFTWARE", "MEDIUM"),
            new Tickets("4", "SOFTWARE", "MEDIUM"),
            new Tickets("5", "SOFTWARE", "HIGH")
        )
        .collect(
            Collectors.groupingBy(Tickets::category, Collectors.mapping(Tickets::priority, Collectors.toSet()))
        ).forEach((k, v) -> {
         System.out.println(k+" "+v);   
        });

    }

    private static void exploringCollectors() {

        Stream<Product> productStream = Stream.of(
            new Product("N1", "C1", 100),
            new Product("N2", "C2", 200),
            new Product("N3", "C2", 200),
            new Product("N4", "C1", 200)
        );
        // 1. ToList, ToMap, ToSet
        // Unlike Normal Map, Stream map uses Fail-Fast as it throws exception if key is present
        // Use mergeFunction Argument to let map know to keep original or keep new.
        // For pulling to List/Set
        // productStream
        // .map(eachProd -> eachProd.name())
        // .collect(Collectors.toList());
        // .collect(Collectors.toSet());
        // .collect(Collectors.toMap(Product::name, Product::category));
        // .collect(Collectors.toMap(Product::name, Product::category, (t, u) -> t));

        // 2. Joining(), joining(separator), joining(separator, prefix, suffix)
        System.out.println(
            Stream.of(1,2,3,4,5,6,7)
            .filter(val -> val%2 == 0)
            .map(eachNum -> eachNum.toString())
            // .collect(Collectors.joining("|"))
            .collect(Collectors.joining("|", "(", ")"))
        );

        // 3. Numeric aggregation
        
        // productStream

        // .collect(Collectors.counting());
        // .collect(Collectors.summingInt(Product::price))
        // .collect(Collectors.averagingInt(Product::price));

        // Better if done this way.
        // .mapToInt(Product::price)
        // .count(); 
        // .sum();
        // .average();

        // Grouping and Partitioning
        Map<Integer, Long> existingMap = new HashMap<>();
        System.out.println(
            "\n--Grouping and Aggregation--\n"+
            productStream

            // Basic Group
            // .collect(Collectors.groupingBy(Product::category)) // Returns Map
            // .get("C1")

            // Group with reduce
            // .collect(Collectors.groupingBy(Product::price, Collectors.counting()))
            
            // Group with Load
            // .collect(Collectors.groupingBy(Product::price,() -> existingMap, Collectors.counting()))
            // +"\n"+existingMap


            // Partition
            .collect(Collectors.partitioningBy(eachProd -> eachProd.price() > 150))
            // .collect(Collectors.partitioningBy(eachProd -> eachProd.price() > 150, Collectors.counting()))
        );

        // Quizing Q3
        List<EmpDep> empList = List.of(
            new EmpDep("e1", "Dep1"),
            new EmpDep("e2", "Dep1"),
            new EmpDep("e3", "Dep2"),
            new EmpDep("e4", "Dep2"),
            new EmpDep("e5", "Dep3")
        );

        System.out.println(
            empList.stream()
            .collect(Collectors.groupingBy(
                    EmpDep::department, 
                    // Collectors.toSet()
                    Collectors.mapping(EmpDep::lastName, Collectors.toList())
                ))
        );


    }

    private static void exploringOptionalsInStream() {
        LongStream ls = LongStream.of(1,3,5,7);
        Stream<String> ss = Stream.of("A", "B", "C", "D");

        // get() or its primitive variant of getAs[primitive] 
        // - Bad unless there is 100% certain of null absence
        ls
            .filter(eachVal -> eachVal%2==0)
            .findFirst()
            // .getAsLong(); // bad if filter returns null
            // .orElse(0); // sets defaut value if null | great 
            .orElseGet(() -> 0); // Since supplier, only builds when called
        ss
            .filter(eachStr -> "Z".equals(eachStr))
            .findFirst()
            // .get(); // bad if filter returns null
            // .orElse(new String("Not found")); //Set default value\
            //  | since it works as a method, the object always creates regardless of null.
            .orElseGet(() -> new String("Not found!"));

        // Throw Exception
        IntStream.of(1)
            .filter(a -> a == 1)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No 2 found :)"));
        
        // IfPresent
        Stream.of("a","c","d")
            .filter(eachVal -> "Z".equals(eachVal))
            .findFirst()
            .ifPresent(foundVal -> System.out.println("Value found: " + foundVal));
        
        printLine();

        // else for the if in IfPresent
        Stream.of("a","c","d")
            .filter(eachVal -> "Z".equals(eachVal))
            .findFirst()
            .ifPresentOrElse(
                matchedString -> System.out.println("Value Found: " + matchedString)
                , 
                () -> System.out.println("No matches found! :( ")
            );
        
        printLine();

        // The or fallback
        Stream.of("a","c","d")
            .filter(eachVal -> "Z".equals(eachVal))
            .findFirst()
            .or(StreamAPI_v2::retursNullOnly)
            .or(StreamAPI_v2::alsoReturnsNullOnly)
            .ifPresentOrElse(
                foundVal -> System.out.println("Value found: " + foundVal)
                ,
                () -> System.out.println("Even after all the or(), could not find it") 
            );

        printLine();
        
        
    }

    private static Optional<String> alsoReturnsNullOnly(){
        return retursNullOnly();
    }

    private static Optional<String> retursNullOnly(){
        System.out.println("returning null :)");
        return Optional.ofNullable(null);
    }

    private static void testingPrimitiveStreams() {
        
        // Chal 1
        double average = IntStream.generate(() -> new Random().nextInt(100))
        .limit(10)
        .filter(eachInt -> eachInt%2==0)
        .average()
        .orElse(0.0D);
        System.out.println("Average is: " + average);

        // Chal 2
        List<String> binaryList = IntStream.rangeClosed(10, 20)
        .mapToObj(Integer::toBinaryString)
        .toList();
        System.out.println(binaryList);

        // Chal 3
        long n = 10L;
        long factResult = LongStream.rangeClosed(1,n)
        .reduce(1, (result, eachVal) -> result = eachVal * result); 

        System.out.println("Fact of " + n + " is " + factResult);

    }

    private static void learningPrimitiveStreams() {
        /*
        All below ways of using primitive in stream will use Stream<Integer>
        which is expensice due to autoboxing
        */

        // Stream.of(1,2,2);
        // Arrays.asList(1,2,3,4).stream();
        // new ArrayList<Integer>().stream();

        /*
        Sourcing a intStream
        */

        // Range
        IntStream.range(1, 10)
            .sum();

        // Arrays to IntStream
        Arrays.stream(new int[]{1,2,3,4,5})
            .sum();
        
        // Using MapTo
        List<Usr> usrList = new ArrayList<>();
        usrList.stream()
            // .map(eachUser -> eachUser.getuSalary())
            .mapToLong(Usr::getuSalary)
            .max()
            .orElse(0);
        
        // Unique Stream Functions
        IntStream strm = IntStream.of(1,2,3);

        // Streams are exhaustive, can only be used once!!
        // strm.sum();
        // strm.average();
        // strm.min();
        // strm.max();
        // Below will do all above
        IntSummaryStatistics stats = strm.summaryStatistics();

        strm.boxed();
       
       System.out.println(
        "Stats: " + 
        stats
       );


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

        // int lessThan18 = ages.filter(eachItem -> eachItem < 18).findFirst().get();
        // boolean allAbove18 = ages.allMatch(eachAge -> eachAge >= 10);
        // int youngestUser = ages.min(Integer::compareTo).get();
        // Integer firstUserAbove28 = ages.filter(eachUserAge -> eachUserAge > 28).findFirst().get();

        ages.collect(Collectors.toList());
        ages.toList();

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


