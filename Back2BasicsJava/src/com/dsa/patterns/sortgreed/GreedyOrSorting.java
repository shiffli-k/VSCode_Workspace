package com.dsa.patterns.sortgreed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GreedyOrSorting {
    public static void main(String[] args) throws Exception {
        int[] actStart = {1, 3, 0, 5, 8, 5};
        int[] actEnd = {2, 4, 6, 7, 9, 9};
        
        /*
         * Store in Pairs
         * Sort based on endTime
         * Iterate through and find if current Activity start 
         * is on or before prev end time
         */

         int countOfActivities = getCountOfActivities(actStart, actEnd);
         System.out.println("Number of activities: " + countOfActivities);
    }

    private static int getCountOfActivities(int[] actStart, int[] actEnd) throws Exception {
        List<Activity> activityList;
        
        int activityCounter = 0;
        int prevActEndTime = 0;

        if(actStart.length != actEnd.length)
            throw new Exception("Nope, Start and end dont match");

        System.out.println("PreSort: " + Arrays.toString(actStart) + " | " + Arrays.toString(actEnd));
        sortingWithBubbleSort(actStart, actEnd);
        System.out.println("PostSort: " + Arrays.toString(actStart) + " | " + Arrays.toString(actEnd));
        
        activityList = new LinkedList<>();
        for (int i = 0; i < actEnd.length; i++) {
            activityList.add(new Activity(actStart[i], actEnd[i]));
        }

        for (Activity currentActivity : activityList) {
            if (currentActivity.getStartTime() >= prevActEndTime) {
                ++activityCounter;
                prevActEndTime = currentActivity.getEndTime();
            }
        }

        return activityCounter;
    }

    private static void sortingWithBubbleSort(int[] actStart, int[] actEnd) {

        for (int i = 0; i < actEnd.length; i++) {
            for (int j = 0; j < actEnd.length - i - 1; j++) {
                if(actEnd[j] > actEnd[j+1]){
                    int mem1;
                    int mem2;
                    
                    // Swap Start
                    mem1 = actEnd[j];
                    actEnd[j] = actEnd[j+1];
                    actEnd[j+1] = mem1;
                    
                    // Swap Start
                    mem2 = actStart[j];
                    actStart[j] = actStart[j+1];
                    actStart[j+1] = mem2;
                }
            }
        }

    }
}

class Activity{
    private int startTime;
    private int endTime;

    Activity(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public int getStartTime() {
        return startTime;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public int getEndTime() {
        return endTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}