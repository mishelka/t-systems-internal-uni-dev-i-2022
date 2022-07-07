package shapes;

public class TestMoveShapes {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Point(2, 3),
            new Point(4, 5),
            new Line(new Point(1, 1), new Point(3, 4))
        };

        print(shapes);
        move(shapes, 1, 1);
        print(shapes);
    }

    private static void move(Shape[] shapes, int dx, int dy) {
        for (Shape shape : shapes) {
            shape.move(dx, dy);
        }
    }

    private static void print(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
