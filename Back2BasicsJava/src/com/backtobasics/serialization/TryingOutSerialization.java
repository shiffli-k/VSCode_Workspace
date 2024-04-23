package com.backtobasics.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TryingOutSerialization {

    private static final String FILE_PATH = "D:\\Documents\\dev_workspace\\VSCode_Workspace\\Back2BasicsJava\\SerializedOutput\\out.txt";

    public static void main(String[] args) {
        CarClass carA = new CarClass("BrandA", 5);
        carA.setSpecificCustomization("Some Extra features.");
        CarClass carB = new CarClass("InvalidBrand", 10);
        // checkFileExistance();
        // serializeToFile(carA);
        
        passref(carB);
        // carB = deSerializeFromFileToObj(carB);

        // Checking
        System.out.println("CAR A name is "+carA.getBrandName()+" | Car B name is "+carB.getBrandName());
        System.out.println("Transient feature of CAR A: "+carA.getSpecificCustomization()+" | is not carried over to CAR B: "+carB.getSpecificCustomization());
    }

    private static void passref(CarClass passedobj){
        try{
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            passedobj = (CarClass) objIn.readObject();
            objIn.close();
            System.out.println("De-Serialized Successfully");
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static CarClass deSerializeFromFileToObj(CarClass passedobj){
        try{
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            passedobj = (CarClass) objIn.readObject();
            objIn.close();
            System.out.println("De-Serialized Successfully");
            return passedobj;

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return passedobj;
    }

    private static void serializeToFile(CarClass passedObject) {
        try{
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(passedObject);
            objOut.flush();
            objOut.close();

            System.out.println("File Written Successfully");
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    private static void checkFileExistance(){
        File myFile = new File(FILE_PATH);
        if(myFile.exists())
            System.out.println("Exists");
        else if(myFile.mkdirs()){
            System.out.println("Either File or Path non existance, created now.");
        }else{
            System.out.println("File/Path non existant, nor were able to create.");
        }
    }


}
