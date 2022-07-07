package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingFromSystemIn {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String s;        
        do {
            System.out.println("Enter text: ");
            s = input.readLine();
            System.out.println("Echo: " + s);
        } while (!"".equals(s));
    }
}
