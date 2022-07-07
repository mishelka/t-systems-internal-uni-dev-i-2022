package threads;

public class Consumer extends Thread {
    private final String name;

    private ExchangeBuffer cubbyhole;
    
    public Consumer(String name, ExchangeBuffer c) {
        this.name = name;
        this.cubbyhole = c;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = cubbyhole.get(name);
            
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
