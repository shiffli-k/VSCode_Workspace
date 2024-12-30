package com.jst.testing;

/**
 * Summary takeaway is that Java does auto-boxing and unboxing for primitive but not for arrays!
 * 
 */
public class AutoBoxingNUnboxingArrays {


    public static void main(String[] args) {

        // basicAutoBoxingNUnboxing();
        basicAutoBoxingNUnboxingArr();
        return;

    }

    private static void basicAutoBoxingNUnboxingArr() {
        int[] primArr = { 1, 2, 3 };
        Integer[] objArr = { 4, 5, 6 };

        // autoBoxingTestArr(primArr);
        autoBoxingTestArr(objArr);

        unboxBoxingTestArr(primArr);
        // unboxBoxingTestArr(objArr);

        return;
    }

    private static void basicAutoBoxingNUnboxing() {
        int prim = 1;
        Integer obj = 2;
        Integer objCon = new Integer(3);

        autoBoxingTest(prim);
        autoBoxingTest(obj);
        autoBoxingTest(objCon);

        unboxBoxingTest(prim);
        unboxBoxingTest(obj);
        unboxBoxingTest(objCon);
        return;
    }

    private static void autoBoxingTest(Integer passedInteger) {
        System.out.println("Autoboxed Passed Integer: " + passedInteger);
        return;
    }

    private static void unboxBoxingTest(int passedInteger) {
        System.out.println("Unboxed Passed Integer: " + passedInteger);
        return;
    }

    private static void autoBoxingTestArr(Integer[] passedIntegerArr) {
        System.out.println("Autoboxed Passed Integer: " + passedIntegerArr[0]);
        return;
    }

    private static void unboxBoxingTestArr(int[] passedIntegerArr) {
        System.out.println("Unboxed Passed Integer: " + passedIntegerArr[0]);
        return;
    }
}