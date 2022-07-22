package threads;

public class Kuchar extends Thread {
    private final String name;

    private RestauracnyPult restauracnyPult;

    public Kuchar(String name, RestauracnyPult c) {
        this.name = name;
        this.restauracnyPult = c;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            restauracnyPult.put(name, i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
