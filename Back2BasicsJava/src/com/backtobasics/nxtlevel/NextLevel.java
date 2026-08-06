package com.backtobasics.nxtlevel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NextLevel {
    
    public static void main(String[] args) {
        // day15June26("racecar", "malayalam", "test", "notAPalindromeWord");
        // day15June26_Simple("racecar", "malayalam", "test", "notAPalindromeWord");
        // day16June26();
        // anita_BiFunction_15Jul26();
        // a_EmpAverageSal(List.of());
        // a_EmpDets();
        // July27Strings();
        
        var empList = List.of(
            new Emp(1, "e1", "d1", 1000),
            new Emp(2, "e2", "d1", 1000),
            new Emp(3, "e3", "d1", 1000),
            new Emp(4, "e4", "d2", 1000),
            new Emp(5, "e5", "d2", 1000),
            new Emp(6, "e6", "d3", 1000),
            new Emp(7, "e7", "d3", 1000)
        );
        Aug06_EmployeeProcess(empList);

    }

    private static void July27Strings() {

        /*
            String str = "Java Stream API";
            Find the duplicate characters and print and eliminate spaces ..only duplicate characters need to be printed
        */

        String duplicateCharsAre =
        "Jaaavaa StreammmAPiiiii aaare coooooolll but not reallyyy".chars()
            .mapToObj(c -> (char)c)
            .filter(eachChar -> Character.isAlphabetic(eachChar))
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                )
            )
            .entrySet().stream()
            .filter(eachEntry -> eachEntry.getValue() > 1)
            .map(eachSet -> String.valueOf(eachSet.getKey()))
            .collect(Collectors.joining());
        IO.print("Duplicates are: " + duplicateCharsAre +"\n");

        /*
            String str = "anita"
            Find the last non-repeating character and print -'t' using stream.
        */
        String theString = "anita";
        Map<Character, Long> mapCharCount = theString.chars().mapToObj(c -> (char)c)
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                )
            );
        
        Character lastRepeatingChar = new StringBuilder(theString).reverse().toString().chars().mapToObj(c -> (char)c)
            .filter(eachChar -> mapCharCount.getOrDefault(eachChar, 0L) == 1)
            .findFirst().orElseThrow();
        
        IO.println("Last repeating Char is: " + lastRepeatingChar);

    }

    private record Emp(int id, String name, String dept, double salary){}

    private static void Aug06_EmployeeProcess(List<Emp> empList) {

        // Highest Paid Employee
        Comparator<Emp> compareBySalary = Comparator.comparingDouble(Emp::salary);
        Emp highestSalaryEmp = empList.stream()
            .max(compareBySalary).orElseThrow();

        IO.println("Highest Paid Employee: " + highestSalaryEmp);
        
        // Employee By Department
        Map<String, List<Emp>> empGrpedByDept = empList.stream()
            .collect(Collectors.groupingBy(Emp::dept));

        IO.println("Employees Grouped by Department: " + empGrpedByDept);

        //Second Highest Salary
        Emp secondHighestPaidEmp = empList.stream().sorted(compareBySalary.reversed())
            .skip(1)
            .limit(1)
            .findFirst().orElseThrow();
        
        IO.println("Employee with the second highly paid is: " + secondHighestPaidEmp);

        // Find Duplicate Employees | Assuming ID is the Unique Identifier
        Map<Integer, Long> empCountGroup =  empList.stream()
            .collect(
                Collectors.groupingBy(
                    Emp::id,
                    Collectors.counting()
                )
            );
        String listOfDuplicateIDs = empCountGroup.entrySet().stream()
        .filter(eachEntrySet -> eachEntrySet.getValue() > 1)
        .map(eachEntry -> String.valueOf(eachEntry.getKey()))
        .collect(Collectors.joining(","));
        // .collect(
        //     StringBuilder::new,
        //     (theBuilder, theEntry) -> theBuilder.append(", " + theEntry.getKey()),
        //     (theBuilder, theEntry) -> theBuilder.append(theEntry.toString())
        // ).toString();

        IO.println("List of Duplicate IDs: " + listOfDuplicateIDs);

        var result = empList.stream()
            .collect(
                Collectors.groupingBy(
                    Emp::dept,
                        Collectors.mapping(
                            Emp::name, 
                            Collectors.toList()
                        )
                    )
                );
        
        IO.println("List of EMP By Department: " + result);
    }


    private record EmployeeDetails(int id, String name, String dept, int sal){};

    private static void a_EmpDets() {

        List<EmployeeDetails> employees = Arrays.asList(
		    new EmployeeDetails(1, "John", "IT", 50000),
		    new EmployeeDetails(2, "Alice", "HR", 45000),
		    new EmployeeDetails(3, "Bob", "IT", 60000),
		    new EmployeeDetails(4, "David", "Finance", 55000),
		    new EmployeeDetails(5, "John", "IT", 50000),
		    new EmployeeDetails(6, "Emma", "HR", 70000),
		    new EmployeeDetails(7, "Tom", "IT", 80000),
		    new EmployeeDetails(7, "Tom", "IT", 80000),
		    new EmployeeDetails(8, "Sam", "Finance", 55000),
		    new EmployeeDetails(9, "Peter", "IT", 90000),
		    new EmployeeDetails(10, "Bob", "IT", 60000),
		    new EmployeeDetails(10, "Bob", "IT", 60000),
		    new EmployeeDetails(10, "Bob", "IT", 60000)
		);

        employees.stream()
        .collect(
            Collectors.groupingBy(
                EmployeeDetails::name,
                Collectors.counting()
            )
        ).entrySet().stream()
        .filter(eachEntry -> eachEntry.getValue() > 1)
        .peek(System.out::println)
        .map(Map.Entry::getKey)
        .toList();


    }

    public record EmpInfo(String name, String department, Double salary){};

    public static String a_EmpAverageSal(List<EmpInfo> Employees){

        if(Employees ==null || Employees.isEmpty()) return "None";

        return Employees.stream()
        .collect(
            Collectors.groupingBy(
                EmpInfo::department,
                Collectors.averagingDouble(EmpInfo::salary)
            )
        )
        .entrySet().stream()
        // .max((o1, o2) -> Double.compare(o1.getValue(), o2.getValue()))
        .max(Map.Entry.comparingByValue())
        .map(maxEntrySet -> maxEntrySet.getKey())
        .orElse("None");
        
    }

    private static void anita_BiFunction_15Jul26() {
        /*
        Question: Create a BiFunction<String,Integer,String> that repeats a string twice if the integer is 2.
        */

        BiFunction<String, Integer, String> theBiFun = (theString, dupeBy) ->{

            StringBuilder dupeBuilder = new StringBuilder();
            IntStream.range(1, dupeBy)
            .forEach(eachTurn -> dupeBuilder.append(eachTurn + ": " + theString + "\n"));

            return dupeBuilder.toString();
        } ;

        System.out.println(theBiFun.apply("Hello", 5));

        /*
        Create a BiPredicate<String,String> that validates login credentials.
            username = "admin"
            password = "123"
        */
       BiPredicate<String, String> validateCreds = (uName, uPwd) -> {
        boolean isUnameValid = "validUname".equals(uName);
        boolean isPwdValid = "thePWD".equals(uPwd);
        if(isUnameValid && isPwdValid)
            return true;
        else
            return false;
       };

    }

    private static void day16June26() {

        getCharCount("ThisIsAWord");
        getAnagram("gnaaram", "anagram");
        getAnagram("yes", "noo");
        

    }

    private static void getAnagram(String firstString, String secondString) {
        
        final int charAId = 97;
        
        if (Integer.compare(firstString.length(), secondString.length()) != 0) {
            System.out.println("Not anagram | since they are of different length");
        }

        firstString = firstString.toLowerCase();
        secondString = secondString.toLowerCase();

        int[] charMap = new int[26];

        for (int i = 0; i < firstString.length(); i++) {
            int firstChar = firstString.charAt(i);
            int secondChar = secondString.charAt(i);

            ++charMap[firstChar-charAId];
            --charMap[secondChar-charAId];

        }

        for (int eachVal : charMap) {
            if(eachVal != 0){
                System.out.println("Not an Anagram");
                return ;
            }
        }

        System.out.println("They are anagram!");

        return;

    }

    private static void getCharCount(String theWordToReturnCountFor) {
        
        theWordToReturnCountFor = theWordToReturnCountFor.toLowerCase();

        final int charAId = 97;
        final int[] charMap = new int[26];

        for (int i = 0; i < theWordToReturnCountFor.length(); i++) {
            int currentChar = theWordToReturnCountFor.charAt(i);
            int mapIndex = currentChar - charAId;
            
            ++charMap[mapIndex];

        }

        for (int i = 0; i < charMap.length; i++) {
            if(charMap[i] != 0){
                System.out.println((char)(i+charAId) + " count is " + charMap[i]);
            }
        }


    }

    private static void day15June26_Simple(String... words) {
        for (String eachWord : words) {
            if(eachWord.toLowerCase().equals(new StringBuilder(eachWord.toLowerCase()).reverse().toString()))
                System.out.println(eachWord + " are in pallindrom.");
            else
                System.out.println(eachWord + " are not in pallindrom.");
        }
    }

    private static void day15June26(String... words) {

        Arrays.stream(words)
        .collect(
            Collectors.toMap(
                word -> word.toLowerCase(),
                word -> new StringBuilder(word).reverse().toString().toLowerCase(),
                (existingKey, incomingKey) -> existingKey // Duplicate Key handling
            )
        ).forEach((originalString ,reversedString) -> {
            if(originalString.equals(reversedString))
                System.out.println(originalString + " & " + reversedString + " are in pallindrom.");
            else
                System.out.println(originalString + " & " + reversedString + " are not in pallindrom.");
            });
        
    }

    //----------------------------

}
