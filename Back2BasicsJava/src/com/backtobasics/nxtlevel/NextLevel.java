package com.backtobasics.nxtlevel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
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
        a_EmpDets();

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
