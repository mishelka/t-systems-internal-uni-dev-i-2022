package threads;

public class SimpleThreadsTest2 {
    public static void main(String[] args) {
        new Thread(new SimpleRunnable("Jamaica")).start();
        new Thread(new SimpleRunnable("Fiji")).start();
    }
}