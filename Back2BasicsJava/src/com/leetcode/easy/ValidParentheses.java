package com.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class ValidParentheses {
    // 20. Valid Parentheses

    public static void main(String[] args) {
        // isValidParentheses("({[]})");
        // isValidParentheses("({)}");
        // isValidParentheses("(AH)");
        // isValidParentheses("{  }");
        isValidParentheses("{(())}}");
    }

    public static final List<Character> OPENER = List.of('{', '[', '(');
    public static final List<Character> CLOSER = List.of('}', ']', ')');
    public static final Map<Character,Character> bracketReference = Map.of(
        '}', '{',
        ']', '[',
        ')', '('
    );
    
    private static boolean isValidParentheses(String theParanthesis) {
        
        IO.println("\n--- Processing `" + theParanthesis + "` ---");

        if(theParanthesis!=null && theParanthesis.isBlank()){
            throw new RuntimeException("User dumb, no data in param. :( | Me Angry >.< ");
        }

        Deque<Character> charStack = new ArrayDeque<>();
        
        for(char eachChar : theParanthesis.toCharArray()){

            boolean isOpener = OPENER.contains(eachChar);
            boolean isCloser = CLOSER.contains(eachChar);

            if(charStack.isEmpty() || isOpener){
                charStack.push(eachChar);
            }else if (isCloser){
                // eahcChar is a closer
                // peek and see if its matching or something idk I am lost bruh
                Character theCharacterInStack = charStack.peek();
                Character theExpectedOpener = bracketReference.get(eachChar);
                if(theCharacterInStack.equals(theExpectedOpener)){
                    IO.println("\tDEBUG: " + theCharacterInStack + " closed by " + eachChar);
                    charStack.pop();
                    continue;
                }else{
                    IO.println("--- `" + theExpectedOpener + "` was not present when closing by `" + eachChar+"` | Thus failing validation ---");
                    return false;
                }

            }else{
                IO.println("\tDEBUG: What do you expect me to do with this: `" + eachChar + "` :( | I will ignore this and move on...");
            }

        }

        IO.println("--- Iteration completed | unclosed count is " + charStack.size() + " thus returning response: " + charStack.isEmpty() + " ---");
        return charStack.isEmpty();
    }
}
