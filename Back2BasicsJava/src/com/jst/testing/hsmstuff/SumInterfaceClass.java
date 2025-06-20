package com.jst.testing.hsmstuff;

public class SumInterfaceClass implements SumInterface{

    @Override
    public void doSum(int a, int b) {
        System.out.println("Sum is " + a+b);
    }

}
