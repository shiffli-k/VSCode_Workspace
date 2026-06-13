package com.backtobasics.threads;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class WorkingWithThreadsAndStuff {
    public static void main(String[] args) throws Exception {
        breakingIntoRunnable();
    }

    private static void breakingIntoRunnable() throws InterruptedException {

        int threadSize = 2;

        Runnable task1 = () -> {

            IntStream.range(0, 1000 / threadSize)
                    .forEach(v -> {
                        Counter.increment();
                        // System.out.println(Counter.getVal() + " | from " + Thread.currentThread().getName());
                    });
                    
            // System.out.println(Counter.getVal() + " | from " + Thread.currentThread().getName());
        };

        ExecutorService exec = Executors.newFixedThreadPool(threadSize);

        IntStream.range(0, threadSize)
            .forEach(v -> {
               System.out.println(LocalTime.now() + " Starting Thread: " + v); 
                exec.submit(task1);
            });
        
        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.MINUTES);
        
        System.out.println(LocalTime.now() +" Executor Shutdown - Current Count: " + Counter.getVal());
    }

}

class Counter {
    private static int val = 0;

    public static synchronized int increment(){
        return ++val;
    }

    public static int incrementNotThreadSafe(){
        return ++val;
    }

    public static synchronized int getVal(){
        return val;
    }
}
