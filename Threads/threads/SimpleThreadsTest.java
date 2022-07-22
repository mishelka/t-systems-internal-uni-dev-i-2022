package threads;

public class SimpleThreadsTest {
    public static void main(String[] args) {
        System.out.println("JAHODKA");
        new SimpleThread("Jamaica").start();
        new SimpleThread("Fiji").start();
        System.out.println("MALINKA");
    }
}