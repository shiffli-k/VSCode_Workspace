package com.backtobasics.jav.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.logging.Logger;

public class WorkingWithJavaTimePkg {
    private static final Logger ConsoleLogger = Logger.getLogger(WorkingWithJavaTimePkg.class.getName());

    public static void main(String[] args) {
        ConsoleLogger.info("Started in Main");
        // tryingOutLocalDate();
        tryingOutLocalTime();

    }

    private static void tryingOutLocalTime() {
        ConsoleLogger.info("Workign with Time stuff");
        LocalTime timeNow = LocalTime.now();
        LocalTime timeSunset = LocalTime.of(18, 30);
        ConsoleLogger.info("The Time is now: " + timeNow);
        ConsoleLogger.info("The Sun will set at: "+ timeSunset);

        Duration timeTillSunset = Duration.between(timeNow, timeSunset);
        ConsoleLogger.info("We have " + timeTillSunset.toHours() + " hours till sunset");

        
    }

    private static void tryingOutLocalDate() {
        LocalDate dateToday = LocalDate.now();
        LocalDate dateChristmas = LocalDate.of(2025, 1, 1);
        ConsoleLogger.info("Fetched Dates Successfully");

        ConsoleLogger.info("Today's date is: " + dateToday);
        ConsoleLogger.info("Christmas is on: " + dateChristmas);

        Period PeriodTillNewYear = Period.between(dateToday, dateChristmas);

        ConsoleLogger.info("Days till New Year: " + PeriodTillNewYear.getDays());
    }
}
