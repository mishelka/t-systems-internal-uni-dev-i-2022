package sk.tuke.kpi.persons;

import cars.Car;

public class TestSort {
    public static void main(String[] args){
        //Array of person
        Person[] persons = new Person[5];
        persons[0] = new Person("Jano","Modry");
        persons[1] = new Person("Fero","Zeleny");
        persons[2] = new Person("Zuza","Modra");
        persons[3] = new Person("Jano","Zeleny");
        persons[4] = new Person("Anna","Modra");

        Car[] cars = {
                new Car("Trabant"),
                new Car("Volvo"),
                new Car("Audi"),
                new Car("BMW"),
                new Car("Toyota"),
                new Car("Citroen")
        };

        //Sorting
        ArraySort as = new ArraySort();
        as.sort(persons);
        
        //Printing sorted array
        for(Person p : persons) {
            System.out.println(p);
        }

        as.sort(cars);
        for(Car c : cars) {
            System.out.println(c);
        }
    }
}
