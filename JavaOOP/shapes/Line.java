package shapes;

public class Line extends Shape {
    private final Point from;

    private final Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Line(Point from, Point to, int color) {
        super(color);
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    public void move(int dx, int dy) {
        getFrom().move(dx, dy);
        getTo().move(dx, dy);
    }

    public String toString() {
        if (getFrom() != null && getTo() != null) {
            return "(" + getFrom().toString() + ") -> (" + getTo().toString() + ")" + super.toString();
        }
        return "? -> ?"  + super.toString();
    }
}
