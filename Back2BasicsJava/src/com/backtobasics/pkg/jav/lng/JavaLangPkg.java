package com.backtobasics.pkg.jav.lng;

import java.util.LinkedList;
import java.util.List;

import com.backtobasics.pkg.jav.lng.test.BasicCounter;

public class JavaLangPkg {

    private static long counter = 0L;

    public static void main(String[] args) throws InterruptedException {
        // gettingSystemProperty();
        // systemTime();
        // throw new InterruptedException("EhYoooo");
        // exitWithCode(); System.out.println("I am here");
        // workingWithThreads();

        // OutOfMemoryError(); // Sadly didnt happen much

        makingThemStackOverflow();

    }

    private static void makingThemStackOverflow() {
        try {
            stackOverflow();
        } catch (StackOverflowError e) {
            System.out.println("It happened! at "+counter+" | DrumRollPls: "+ e.getClass());
        }
    }

    private static String stackOverflow() {
        System.out.println("Resursing! " + (counter++));
        try {
            // Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stackOverflow();
    }

    private static void OutOfMemoryError() {
        List<BasicCounter> obj = new LinkedList<>();
        Runnable outOfMemPls = () -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println("Iterating: " + i + " times. By thread name: " + Thread.currentThread());
                obj.add(new BasicCounter().clickTimes((long) (Math.random() * 10000)));
            }
        };
        new Thread(outOfMemPls, "T1").start();
        new Thread(outOfMemPls, "T2").start();
        new Thread(outOfMemPls, "T3").start();
        new Thread(outOfMemPls, "T4").start();
        new Thread(outOfMemPls, "T5").start();
        new Thread(outOfMemPls, "T6").start();
        new Thread(outOfMemPls, "T7").start();
        new Thread(outOfMemPls, "T8").start();
    }

    private static void workingWithThreads() {

        int iterateLimit = 10000;
        BasicCounter bc = new BasicCounter();
        Runnable myTask = () -> {
            for (int i = 0; i < iterateLimit; i++) {
                bc.click();
            }
        };
        Thread t1 = new Thread(myTask);
        Thread t2 = new Thread(myTask);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Expected Val: " + (iterateLimit * 2));
        System.out.println("Actual Val: " + bc.getCurrentValue());
    }

    private static void exitWithCode() {
        int rndInt = (int) (Math.random() * 100);
        if (rndInt % 2 == 0) {
            System.out.println("Exiting Normally");
            System.exit(0);
        } else {
            System.out.println("Exiting with ErrorCode" + rndInt);
            System.exit(rndInt);
        }
    }

    private static void systemTime() throws InterruptedException {
        System.out.println(
                "Millis: " +
                        System.currentTimeMillis() +
                        " Nano: " +
                        System.nanoTime());

    }

    private static void gettingSystemProperty() {
        System.out.println(
                "Running on: " +
                        System.getProperty("os.name") +
                        " on Java " +
                        System.getProperty("java.version")

        );
    }
}
