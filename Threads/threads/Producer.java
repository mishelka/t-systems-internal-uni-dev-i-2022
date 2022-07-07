package threads;

public class Producer extends Thread {
    private final String name;

    private ExchangeBuffer cubbyhole;

    public Producer(String name, ExchangeBuffer c) {
        this.name = name;
        this.cubbyhole = c;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyhole.put(name, i);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
}
