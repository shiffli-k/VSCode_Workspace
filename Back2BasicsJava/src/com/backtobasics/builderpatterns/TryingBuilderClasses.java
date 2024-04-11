package com.backtobasics.builderpatterns;

public class TryingBuilderClasses {
    public static void main(String[] args) {
        CarBuilderBasic carA = new CarBuilderBasic
        .CarBuilder()
        .brandName("Mahindra")
        .modelName("ScorpioN")
        .yearOfManufacture(2023)
        .colourOfVehicle("White")
        .buildCar();

        
        System.out.println(carA.getModelName());
    }
}
