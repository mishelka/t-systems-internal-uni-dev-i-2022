package myPersons;

import cars.Car;

public class Person implements Comparable<Person> {
    public static final String JAHODA = "Jahoda";
    private String name; // = null;
    private int age; // = 0;
    private Car car;

    public Person(String name) {
        this(name, 5);
    }

    public Person(String name, int age) {
        this.name = name;
        if(isValidAge(age)) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(isValidAge(age)) {
            this.age = age;
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private boolean isValidAge(int ageNew) {
        return ageNew >= 0 && ageNew <= 150;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                (car != null ? ", car=" + car : "") +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        int nameCompare = this.name.compareTo(p.name);
        if(nameCompare == 0) {
            int ageCompare = this.age - p.age;
            if(ageCompare != 0) {
                return ageCompare;
            } else {
                if(car != null) {
                    return -1;
                } else
                    return this.car.getBrand().compareTo(p.getCar().getBrand());
            }
        }
        return nameCompare;
    }
}
