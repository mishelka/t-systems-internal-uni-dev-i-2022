package reflection;

import java.io.Serializable;

public class Point implements Serializable, Moveable {
    private int x;

    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "["+ x +","+ y +"]";
    }
}
