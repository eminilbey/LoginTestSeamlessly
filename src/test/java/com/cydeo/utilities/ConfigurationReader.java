package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- Create the object of Properties
    private static Properties properties = new Properties();

    static{//static block runs first. That's why it is created so that codes inside the block runs first

        try {

            //2- We need to open the file in java memory: FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");// configuration.properties file is in the stream

            //3- Load the properties object using FileInputStream object
            properties.load(file); // this coding gives the upper class exception
            // the properties file (our data) is loaded to the properties object

            //close the file
            file.close();


        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword){//When this STATIC method called directly via class name, tha STATIC block will run prior to this method
        return properties.getProperty(keyword); // keyword in here is actually "key" (key=value)
    }
}
