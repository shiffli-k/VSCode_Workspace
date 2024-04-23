package com.backtobasics.serialization;

import java.io.Serializable;

public class CarClass implements Serializable{
    private static final long serialVersionUID = 1L;

    private String brandName;
    static String wheelCount = "4 + 1(Spare)";
    private int doorCount;
    transient private String specificCustomization;

    public CarClass() {
    }

    public CarClass(String brandName, int doorCount) {
        this.brandName = brandName;
        this.doorCount = doorCount;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public static String getWheelCount() {
        return wheelCount;
    }
    public int getDoorCount() {
        return doorCount;
    }
    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
    public String getSpecificCustomization() {
        return specificCustomization;
    }
    public void setSpecificCustomization(String specificCustomization) {
        this.specificCustomization = specificCustomization;
    }

    

}
