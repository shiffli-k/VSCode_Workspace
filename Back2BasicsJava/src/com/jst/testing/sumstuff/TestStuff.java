package com.jst.testing.sumstuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestStuff implements Cloneable {

    public static void main(String[] args) throws InterruptedException {
        
        
        arrayWhat();

    }
    




    private static void arrayWhat() {
        int[] myAr = new int[10];
        System.out.println(Arrays.toString(myAr));
        myAr[1]+=1;
        System.out.println(Arrays.toString(myAr));
    }





    private static void reveriseThisB() {
        int loadSize = 10;
        int[] theArr = new int[loadSize];
        loadThisArr(theArr, loadSize);

        System.out.println("Values in Array: " + Arrays.toString(theArr));

        reverseit(theArr);

        System.out.println("Reverse values in Array: " + Arrays.toString(theArr));
    }

    private static void reverseit(int[] theArr) {
        for (int i = 0, j = theArr.length-1; i < j ; i++, j--) {
            int tmp;
            tmp = theArr[i];
            theArr[i]=theArr[j];
            theArr[j]=tmp;
        }
        System.out.println("Whoop, Reversed! I hope.");
    }

    private static void loadThisArr(int[] theArr, int loadNumbers) {
        for (int i = 0; i < loadNumbers; i++) {
            theArr[i]=new Random().nextInt(100);
        }
    }

    private static void threadSafetyOfAHashMapTable() throws InterruptedException {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        ExecutorService execServ = Executors.newCachedThreadPool();

        Runnable task1 = () -> {
            for (int i = 0; i < 100; i++) {
                ht.put(i, 1);
                hm.put(i, i);
            }
        };

        execServ.submit(task1);
        execServ.submit(task1);
        execServ.submit(task1);
        execServ.submit(task1);
        execServ.submit(task1);

        execServ.shutdown();
        execServ.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Size of HashMap " + hm.size());
        System.out.println("Size of HashTable " + ht.size());

    }

    private static void test1() {

        List<String> listOfPossibleValues = new ArrayList<>();
        listOfPossibleValues.add("NoSpace");
        listOfPossibleValues.add("One Space");
        listOfPossibleValues.add("Two  Space");
        listOfPossibleValues.add("Two  Two  Space");
        listOfPossibleValues.add("Three   Two  Space");
        listOfPossibleValues.add("Three   Two  Three   Four    Space");

        listOfPossibleValues.forEach(eachNameInList -> {
            System.out.println(eachNameInList + " : " +
                    parseCustomerName(eachNameInList));
        });
    }

    private static String parseCustomerName(String passedString) {
        StringBuilder filteredUserName = new StringBuilder();
        for (String subStringVal : passedString.split(" ")) {
            if (subStringVal.length() > 0)
                filteredUserName.append(subStringVal).append(" ");
        }
        return filteredUserName.toString();
    }

}
