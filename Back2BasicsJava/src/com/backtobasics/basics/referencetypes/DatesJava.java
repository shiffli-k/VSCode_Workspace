package com.backtobasics.basics.referencetypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DatesJava {

    public static void main(String[] args) {
        LocalDate justDate = LocalDate.now();
        System.out.println(justDate.getDayOfYear());
        System.out.println(justDate.isLeapYear());

        LocalTime justTime = LocalTime.now();
        DateTimeFormatter forMatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(forMatter.format(justTime));
    }

}
