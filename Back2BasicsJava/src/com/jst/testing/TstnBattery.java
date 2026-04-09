package com.jst.testing;

import java.awt.AWTException;
import java.util.Random;

public class TstnBattery {
    public static void main(String[] args) throws AWTException, Exception {

        Random rng = new Random();

        while (true) {
            Thread.sleep(rng.nextInt(2000) + 1000);
            System.out.println("Value: " + rng.nextInt(Integer.MAX_VALUE));
        }

    }

}
