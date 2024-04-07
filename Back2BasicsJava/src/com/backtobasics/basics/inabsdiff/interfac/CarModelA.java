package com.backtobasics.basics.inabsdiff.interfac;

public class CarModelA implements VehicleInterface{

    private String CarName;


    public CarModelA(String CarName) {
        this.CarName = CarName;
    }



    @Override
    public void startEngine() {
        System.out.println(CarName + "\'s Engine is Started");
    }

}
