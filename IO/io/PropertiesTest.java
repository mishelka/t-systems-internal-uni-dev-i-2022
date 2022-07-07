package io;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        File file = new File("test.properties");
        System.out.println("Using file: " + file.getAbsolutePath());

        //Create properties object
        Properties props = new Properties();

        //Load from file if the file exists
        if(file.exists()) {
            props.load(new FileInputStream(file));
            System.out.println(props);            
        }

        //Set properties
        props.setProperty("user", "john");
        props.setProperty("passwd", "hrasko");

        System.out.println("JETU IZE " + props.getProperty("ize"));

        //Store properties
        props.store(new FileOutputStream(file), "Test properties");
    }
}


