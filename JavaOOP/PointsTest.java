public class PointsTest {
    public static void main(String[] args) {

        Point p1 = new Point(3, 4);
        Point p2 = p1;

        p1.move(10, 10); //REFERENCIA!
        System.out.println(p1);
        System.out.println(p2);

        int a = 3;
        int b = a;
        a = a + 1;
        System.out.println(a);
        System.out.println(b);
    }
}
