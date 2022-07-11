package shapes;

public class TestShapes {
    
    public static void main(String[] args) {
        Shape[] shapes = {
            new Line(3),
            new Line(5, '#')
            //, new Rectangle(10, 8), new Triangle(5), new Square(8), ...
            //should print whatever shape there is, just needs to extend Shape
        };

        for (Shape s: shapes) {
            System.out.println(s);
        }
    }
}
