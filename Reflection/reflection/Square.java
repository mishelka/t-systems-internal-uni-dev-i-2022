package reflection;

import java.io.Serializable;

public class Square implements Serializable, Moveable {
    private Point point;

    private int size;

    public Square(Point p, int size) {
        this.point = p;
        this.size = size;
    }

    public Square() {
        this(new Point(), 10);
    }
    
    public void move(int dx, int dy) {
        point.move(dx, dy);
    }

    public String toString() {
        return "Square " + point + " a=" + size;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point p) {
        this.point = p;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
