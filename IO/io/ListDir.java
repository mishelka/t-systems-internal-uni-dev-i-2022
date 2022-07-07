package io;

import java.io.File;

public class ListDir {
    public static void main(String[] args) {
        File dir = new File(".");

        if (dir.isDirectory()) {
            System.out.println("Listing of: " + dir.getAbsolutePath());

            //List directory
            for (String fileName : dir.list()) {
                System.out.println("  " + fileName);
            }
        } else {
            System.err.printf("File %s is not directory", dir);
        }
    }
}
