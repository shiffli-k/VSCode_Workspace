package com.backtobasics.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamPractice {
/*

  ──────
  ### 1. Easy Problem: Count Duplicate Strings

  #### Problem Description
  Write a method that takes a list of strings and returns the count of unique strings that appear more than once in the
  list (case-insensitively).

  Your stream pipeline should:

  1. Handle null or empty input lists safely (return 0L).
  2. Filter out null, empty, or whitespace-only strings.
  3. Trim each string and convert it to lowercase.
  4. Count how many unique strings appear strictly more than once in the list.
  5. Return the result as a long.

  #### Starter Code

    import java.util.List;

    public class DuplicateFinder {

        public static long countDuplicateStrings(List<String> items) {
            // TODO: Implement stream pipeline
            return 0L;
        }
        }
        
        #### Example:
        
        • Input: ["apple", "Banana", "APPLE", "  banana  ", "cherry", ""]
        • Normalized items: ["apple", "banana", "apple", "banana", "cherry"]
        • Duplicates: "apple" (appears 2x), "banana" (appears 2x) -> 2 unique duplicates.
        • Output: 2L
        ──────
        
*/
    public static long countDuplicateStrings(List<String> items) {
        
        if(items == null || items.isEmpty()){
            return 0L;
        }

        return items.stream()
            .filter(eachString -> eachString != null && eachString.trim().isEmpty())
            .map(eachString -> eachString.trim().toLowerCase())
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                )
            )
            .entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .map(eachSet -> eachSet.getValue())
            .findFirst().orElse(0L);
        
    }


}
    