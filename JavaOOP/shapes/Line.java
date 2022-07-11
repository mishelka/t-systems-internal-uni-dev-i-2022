package shapes;

public class Line extends Shape {
    int size;

    public Line(int size) {
        //super(); //toto sa vola, pokial nadtrieda ma taky konstruktor
        this.size = size;
    }

    public Line(int size, char color) {
        super(color);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += super.color;
        }
        return s;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
