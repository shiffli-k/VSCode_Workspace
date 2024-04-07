package com.backtobasics.basics.inabsdiff;

import com.backtobasics.basics.inabsdiff.abst.CarModelA;
// import com.backtobasics.basics.inabsdiff.interfac.CarModelA;
import com.backtobasics.basics.inabsdiff.interfac.VehicleInterface;

public class ImplementationTest {
    public static void main(String[] args) {

        CarModelA myNewCar = new CarModelA("myNewCar");
        myNewCar.startEngine();
        
        CarModelA myNewCar2 = new CarModelA("myNewCar2");
        myNewCar2.noOfWheels=5;
        myNewCar2.startEngine();
        System.out.println("Wheel count of MyNewCar is "+myNewCar.noOfWheels);
        System.out.println("Wheel count of MyNewCar2 is "+myNewCar2.noOfWheels);
        
        System.out.println("------------------------- Interfaces Below---------------------");
        
        com.backtobasics.basics.inabsdiff.interfac.CarModelA myNewCarInt = new com.backtobasics.basics.inabsdiff.interfac.CarModelA("myNewCarInt");
        myNewCarInt.startEngine();
        
        com.backtobasics.basics.inabsdiff.interfac.CarModelA myNewCar2Int = new com.backtobasics.basics.inabsdiff.interfac.CarModelA("myNewCar2Int");
        myNewCar2Int.startEngine();
        
        // myNewCar.noOfWheels = 5;
        // VehicleInterface.noOfWheels=5; // Cannnot be done, its Final.
        System.out.println("Wheel count of MyNewCar is "+myNewCarInt.noOfWheels);
        System.out.println("Wheel count of MyNewCar2 is "+myNewCar2Int.noOfWheels);
        


    }
}
