package io;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListDir {
    public static void main(String[] args) {
        String path = ".";
        listDir(new File(path));
        listDir(path);

        List<File> filteredByName = filter("./arrays", "Array");
        List<File> filteredByDate = filter("./arrays", new Date());
    }

    private static void listDir(String fileName) {
        listDir(new File(fileName));
    }

    private static void list(List<File> files) {
        //vypisat zoznam suborov
        //pouzit stream a forEach
    }
    private static void listDir(File f) {
        System.out.println("  " + f.getName());
        if (f.isDirectory()) {
            for(File sub : f.listFiles()) {
                listDir(sub);
            }
        }
    }

    private static List<File> filter(String path, String name) {
        List<File> filtered = new ArrayList<File>();
        File dir = new File(name);
        filter(dir, filtered);
        return filtered;
    }

    private static void filter(File f, List<File> filtered) {
//        if(podmienka) {
//            filtered.add(f);
//        }
//        if(f.isDirectory()) {
//            //for(subf) filter(subf, filtered);
//        }
    }

    private static List<File> filter(String path, Date minDate) {
//        f.lastModified() - vrati long
        return null;
    }
}
