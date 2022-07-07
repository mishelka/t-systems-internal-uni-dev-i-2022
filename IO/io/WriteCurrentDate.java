package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteCurrentDate {
    
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("out.bin");
        ObjectOutputStream s = new ObjectOutputStream(out);
        s.writeObject("Today is: ");
        s.writeObject(new Date());

        List<Point> points = new ArrayList<Point>();
        points.add(new Point(3, 4));
        points.add(new Point(4, 5));
        points.add(new Point(5, 5));
        s.writeObject(points);
        s.close();
        
        System.out.println("The end!");
    }
    
}
