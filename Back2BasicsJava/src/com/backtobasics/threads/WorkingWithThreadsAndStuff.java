package com.backtobasics.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class WorkingWithThreadsAndStuff {
    public static void main(String[] args) throws Exception {
        breakingIntoRunnable();
    }

    private static void breakingIntoRunnable() {

        int counter = 0;
        Runnable task1 =() -> {
            System.out.println("Task 1 called");
        } ;


    }


}
