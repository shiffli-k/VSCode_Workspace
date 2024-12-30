package com.backtobasics.basics.jav.uitls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    public static Properties myConfigProperties;
    static{
        loadProperties();
    }

    private static void loadProperties(){
        myConfigProperties = new Properties();
        try(FileInputStream fisConfig = new FileInputStream("propertiesFolder"+File.separator+"config.properties")) {
            myConfigProperties.load(fisConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
}
