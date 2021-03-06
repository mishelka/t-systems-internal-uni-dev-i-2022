package threads;

public class RestauracnyPult {
    private int contents;

    private boolean available = false;

    public synchronized int get(String who) {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        available = false;
        System.out.println("Casnik " + who + " got: " + contents);

        notifyAll();

        return contents;
    }

    public synchronized void put(String who, int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        available = true;
        System.out.println("Kuchar " + who + " put: " + contents);
        
        notifyAll();
    }
}
