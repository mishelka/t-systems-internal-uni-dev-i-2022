package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

public class ReadCurrentDate {
    
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("out.bin");
        ObjectInputStream s = new ObjectInputStream(in);
        String text = (String) s.readObject();
        Date date = (Date) s.readObject();
        
        List<Point> points = (List<Point>) s.readObject();
        for(Point point : points) {
            System.out.println(point);
        }

        s.close();
        
        System.out.println("Readed data: "+ text + date);
    }
}
