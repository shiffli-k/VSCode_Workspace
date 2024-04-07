package com.backtobasics.basics.inabsdiff.abst;

public class CarModelA extends VehicleAbstract {

    private String CarName;


    public CarModelA(String CarName) {
        this.CarName = CarName;
    }



    @Override
    public void startEngine() {
        System.out.println(CarName + "\'s Engine is Started");
    }


}
