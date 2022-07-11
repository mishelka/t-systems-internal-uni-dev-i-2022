package cars;

public class Car {
    private String brand;
    private boolean started;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public String toString() {
        return brand + '(' +
                (started ? "started" : "stopped") +
                ')';
    }
}
