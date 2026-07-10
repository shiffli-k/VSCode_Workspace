package com.gpt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GptInterview {
    public static void main(String[] args) {
    
        List<Integer> intList = new ArrayList<>();
        Set<Integer> intSet = new HashSet<>();
        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf(2);
        Integer i3 = Integer.valueOf(1);

        intSet.add(i1);
        intSet.add(i2);
        intSet.add(i3);

        System.out.println(
            intSet
        );
    
    }
}