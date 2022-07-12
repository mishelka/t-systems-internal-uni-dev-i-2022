package shapes;

public abstract class Shape
        implements Comparable<Shape> {
    protected char color;

    public Shape() {
        this('*');
    }

    public Shape(char color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public abstract void print();

    @Override
    public int compareTo(Shape o) {
//        if(this.color > o.getColor()) {
//            return -1;
//        }
//        if(this.color < o.getColor()) {
//            return 1;
//        }
//        return 0;
        return this.color - o.getColor();
    }
}
