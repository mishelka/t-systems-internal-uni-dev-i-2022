package io;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLSerialization {
    public static void main(String[] args) throws IOException {
        Object object = new Point(2, 5);

//        //Encode to XML - serialization
//        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("out.xml")));
//        encoder.writeObject(object);
//        encoder.close();

        //Decode from XML - deserialization
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("out.xml")));
        object = decoder.readObject();
        decoder.close();

        System.out.println(object);
    }
}
