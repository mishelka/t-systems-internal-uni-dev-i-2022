package shapes;

import java.util.Arrays;

public class TestShapes {
    
    public static void main(String[] args) {
        Shape[] shapes = {
            new Line(4, 'b'),
            new Line(3, 'z'),
            new Line(5, '#'),
            new Line(4, 'c'),
            new Line(4, 'y'),
            new Line(4, 'a'),
            //, new Rectangle(10, 8, "O"), new Triangle(5, "&"), new Square(8), ...
            //should print whatever shape there is, just needs to extend Shape
        };

        Arrays.sort(shapes);

        for (Shape s: shapes) {
            s.print();
        }
    }
}
