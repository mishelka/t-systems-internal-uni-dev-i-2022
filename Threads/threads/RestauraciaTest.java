package threads;

public class RestauraciaTest {
    public static void main(String[] args) {
        RestauracnyPult c = new RestauracnyPult();
        
        Kuchar p1 = new Kuchar("K1", c);
        Casnik c1 = new Casnik("C1", c);
        Kuchar p2 = new Kuchar("K2", c);
        Casnik c2 = new Casnik("C2", c);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }
}
