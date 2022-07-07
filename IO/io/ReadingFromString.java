package io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReadingFromString {
    public static void main(String[] args) throws IOException {
        String str = "Hello World!";
        
        Reader fr = new StringReader(str);
        int c;
        while((c = fr.read()) != -1) {
            System.out.print((char)c);
        }
        
        fr.close();
    }
}
