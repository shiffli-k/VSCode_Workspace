package com.dsa.patterns.sortgreed;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCompare {
    public static void main(String[] args) {
        DateTimeFormatter logFormatter = DateTimeFormatter.ofPattern("HH:mm:ss,SSS");

        String pageLoadTime = "18:11:49,774";
        String timeoutReqTime = "18:16:50,673";

        // String pageLoadTime = "11:11:09,201";
        // String timeoutReqTime = "11:16:08,956";

        LocalTime locTime1 = LocalTime.parse(pageLoadTime, logFormatter);
        LocalTime locTime2 = LocalTime.parse(timeoutReqTime, logFormatter);

        Duration dur = Duration.between(locTime1, locTime2);

        System.out.println("ElapsedTime: " + dur.toMillis());
        
    }
}
