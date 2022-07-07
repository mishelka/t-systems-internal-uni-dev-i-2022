package threads;

public class SimpleRunnable implements Runnable {
    private String name;
    
    public SimpleRunnable(String name) {
        this.name = name;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + name);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("DONE! " + name);
    }
}