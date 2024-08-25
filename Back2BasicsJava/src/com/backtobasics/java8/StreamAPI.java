package com.backtobasics.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        tryingOutBasic();
    }

    private static void tryingOutBasic() {
        List<Integer> nums = new ArrayList<>();
        // loadListWithIntegers(nums);
        loadListWithIntegersStream(nums);

        System.out.println("Current List: "+nums);
        
        nums.stream()
        .filter(eachVal -> eachVal % 2 == 0)
        .collect(Collectors.toList());
        
        System.out.println("Updated List: "+nums);
        


    }

    private static void loadListWithIntegers(List<Integer> passedList) {
        Integer limit = (int) (Math.random() * 10);
        for (int iterator = 0; iterator <= limit; iterator++)
            passedList.add((int) (Math.random() * 100));
    }

    private static void loadListWithIntegersStream(List<Integer> passedList) {
        int lmt = (int) (Math.random() * 10) + 4;

        passedList.addAll(
                new Random().ints(lmt, 1, 99)
                        .boxed()
                        .collect(Collectors.toList()));
    }
}
