package cars;

import sk.tuke.kpi.persons.CompareObject;

public class Car implements CompareObject {
    private String brand;
    protected boolean started;

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

    @Override
    public int compareTo(CompareObject obj) {
        if(!(obj instanceof Car)) {
            return -1;
        }
        return this.brand.compareToIgnoreCase(((Car)obj).brand);
    }
}
