package com.backtobasics.jav.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkingWithFiles {
    private static final String EXISTING_FILE = "workingWithFiles/APreExistingFile.txt";

    public static void main(String[] args) {

        File anExistingLocalFile = new File(EXISTING_FILE);
        fileExistanceCheck(anExistingLocalFile);
        usingFileInputStream(anExistingLocalFile);

    }

    private static void usingFileInputStream(File pasedFile) {
        String contentsFromFile = null;
        try (FileInputStream fis = new FileInputStream(pasedFile)){
            while(fis.available() > 0){
                // System.out.print((char)fis.read());
                contentsFromFile += (char)fis.read();
            }
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("The file had this to say: "+ contentsFromFile);

    }

    private static boolean fileExistanceCheck(File passedFile) {
        if (passedFile.exists()){
            System.out.println("Yea, it exists! " + passedFile.getAbsolutePath());
            return true;
        }else{
            System.out.println("Nope, it doesn't exist! " + passedFile.getAbsolutePath());
            return false;
        }
    }
}
