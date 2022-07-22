package io;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

public class ListDirArtem {
    public static void main(String[] args) {
        List<File> filteredByName = filterByName("./arrays", "Array");
        List<File> filteredByDate = filterByDate("./arrays", new GregorianCalendar(2022, Calendar.JULY, 21).getTime());
//        List<File> filteredBinFiles = fiterBinFiles(".");
        System.out.println("By name:");
        list(filteredByName);
        System.out.println("By date:");
        list(filteredByDate);
//        list(filteredBinFiles);
    }

    private static void listDir(String fileName) {
        listDir(new File(fileName));
    }

    private static void list(List<File> files) {
        //vypisat zoznam suborov
        //pouzit stream a forEach
        files.stream().forEach(file -> listDir(file));
    }

    private static void listDir(File f) {
        System.out.println("  " + f.getName());
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                listDir(sub);
            }
        }
    }

    private static List<File> fiterBinFiles(String path) {
        List<File> filtered = new ArrayList<>();
        File dir = new File(path);

        FileFilter binFileFilter = f -> f.getName().endsWith(".bin");

        filterUsingFileFilter(dir, binFileFilter, filtered);
        return filtered;
    }

    private static List<File> filterByName(String path, String name) {
        List<File> filtered = new ArrayList<>();
        File dir = new File(path);
//        FileFilter dateFileFilter = new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                return f.getName().contains(name);
//            }
//        };

        FileFilter nameFileFilter = f -> f.getName().contains(name);

        filterUsingFileFilter(dir, nameFileFilter, filtered);
        return filtered;
    }

    private static List<File> filterByDate(String path, Date maxDate) {
        List<File> filtered = new ArrayList<>();
        File dir = new File(path);
//        FileFilter dateFileFilter = new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                return new Date(f.lastModified()).after(maxDate);
//            }
//        };

        FileFilter dateFileFilter = f -> new Date(f.lastModified()).after(maxDate);

        filterUsingFileFilter(dir, dateFileFilter, filtered);
        return filtered;
    }

    private static void filterUsingFileFilter(File f, FileFilter filter, List<File> filtered) {
        if(f.isDirectory()) {
            filtered.addAll(Arrays.asList(f.listFiles(filter)));
            for(File sub : f.listFiles()) {
                filterUsingFileFilter(sub, filter, filtered);
            }
        }
    }

    private static void filterRecursive(File f, List<File> filtered) {
        if (!f.isDirectory()) {
            filtered.add(f);
        } else {
            for (File sub : f.listFiles())
                filterRecursive(sub, filtered);
        }
    }
}