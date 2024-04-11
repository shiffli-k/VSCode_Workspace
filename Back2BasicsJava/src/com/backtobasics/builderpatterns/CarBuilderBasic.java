package com.backtobasics.builderpatterns;

public class CarBuilderBasic {
    
    private String brandName;
    private String modelName;
    private int yearOfManufacture;
    private String colourOfVehicle;

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getColourOfVehicle() {
        return colourOfVehicle;
    }

    public CarBuilderBasic(CarBuilder builder) {
        this.brandName=builder.brandName;
        this.modelName=builder.modelName;
        this.yearOfManufacture=builder.yearOfManufacture;
        this.colourOfVehicle=builder.colourOfVehicle;
    }
    
    public static class CarBuilder{
        private String brandName;
        private String modelName;
        private int yearOfManufacture;
        private String colourOfVehicle;

        public CarBuilder(){}

        public CarBuilder brandName(String brandName){
            this.brandName=brandName;
            return this;
        }
        public CarBuilder modelName(String modelName){
            this.modelName=modelName;
            return this;
        }
        public CarBuilder yearOfManufacture(int yearOfManufacture){
            this.yearOfManufacture=yearOfManufacture;
            return this;
        }
        public CarBuilder colourOfVehicle(String colourOfVehicle){
            this.colourOfVehicle=colourOfVehicle;
            return this;
        }

        public CarBuilderBasic buildCar(){
            return new CarBuilderBasic(this);
        }
           
    }

}
