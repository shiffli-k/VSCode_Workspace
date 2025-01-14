package com.backtobasics.threads;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

public class ExecutorFramework {

    public static Logger tLog = Logger.getLogger("Trace");

    /*
     * Executor Interface
     * ExecutorService Interface
     * ScheduledExecutorService Interface
     * ThreadPoolExecutor Class
     * Executors Utility Class
     */

    public static void main(String[] args) {
        // execServWithRunnable();
        // execServWithCallable();
        tryingInvokeAll();
    }

    private static void tryingInvokeAll() {
        List<Callable<String>> listOfRunnable = new ArrayList<>();
        List<Future<String>> executedListOfFutureString = null;
        String executedFutureString = null;
        ExecutorService execServ = Executors.newFixedThreadPool(4);


        for (int i = 0; i < 1000; i++) {
            listOfRunnable.add(() -> {
                String msg = "Hello from Thread "+Thread.currentThread().getName();
                System.out.println(msg);
                return msg;
            }
            );
        }

        try {
            Duration startTime = Duration.ofMillis(System.currentTimeMillis());
            
            executedListOfFutureString = execServ.invokeAll(listOfRunnable, 1, TimeUnit.MILLISECONDS);
            System.out.println("Size of executedListOfFutureString: "+executedListOfFutureString.size());
            
            executedFutureString = execServ.invokeAny(listOfRunnable, 10, TimeUnit.SECONDS);
            System.out.println("Result of a Task: "+executedFutureString);
            
            System.out.println("ProcessingTime: "+Duration.ofMillis(System.currentTimeMillis()).minus(startTime).toMillis());
        } catch (InterruptedException | NullPointerException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }


        execServ.shutdown();

        return;

    }

    private static void execServWithCallable() {
        ExecutorService execServ = Executors.newFixedThreadPool(4);
        Future<String> resultOfCallable;

        Callable<String> callableTask = () -> {
            int taskDuration = new Random().nextInt(1000, 5000);
            tLog.info(Thread.currentThread().getName() + " is executing Task - Processing time is:" + taskDuration);
            Thread.sleep(taskDuration);
            tLog.info(Thread.currentThread().getName() + " has completed execution");
            return "Task Completed in " + taskDuration + " ms";
        };

        resultOfCallable = execServ.submit(callableTask);

        tLog.info("waiting on task completion");
        try {
            if (resultOfCallable.get() != null) {
                tLog.info("Result of Callable Task: " + resultOfCallable.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        execServ.shutdown();

    }

    private static void execServWithRunnable() {
        ExecutorService execServ = Executors.newFixedThreadPool(4);

        Runnable task1 = () -> {
            int taskDuration = new Random().nextInt(1000, 10000);
            tLog.info(Thread.currentThread().getName() + " is executing Task 1 - Processing time is:" + taskDuration);
            try {
                Thread.sleep(taskDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tLog.info(Thread.currentThread().getName() + " is executing Task 1 - Completed");
            return;
        };
        Runnable task2 = () -> {
            int taskDuration = new Random().nextInt(1000, 10000);
            tLog.info(Thread.currentThread().getName() + " is executing Task 2 - Processing time is:" + taskDuration);
            try {
                Thread.sleep(taskDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tLog.info(Thread.currentThread().getName() + " is executing Task 2 - Completed");
            return;
        };

        execServ.submit(task1);
        execServ.submit(task2);

        execServ.shutdown();

        return;
    }
}
