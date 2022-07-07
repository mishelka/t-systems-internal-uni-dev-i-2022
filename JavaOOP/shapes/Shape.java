package shapes;

public abstract class Shape {
    private int color;

    public Shape() {
        this(0);
    }

    public Shape(int color) {
        this.color = color;
    }

    public abstract void move(int dx, int dy);

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String toString() {
        return ": color = " + color;
    }
}
