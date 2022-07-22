package threads;

public class Casnik extends Thread {
    private final String name;

    private RestauracnyPult restauracnyPult;
    
    public Casnik(String name, RestauracnyPult c) {
        this.name = name;
        this.restauracnyPult = c;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = restauracnyPult.get(name);
            
            try {
                sleep((int) (Math.random() * 5000));
            } catch (InterruptedException e) {
            }
        }
    }
}
