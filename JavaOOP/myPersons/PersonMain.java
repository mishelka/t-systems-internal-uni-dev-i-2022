package myPersons;

import cars.Car;
import myPersons.exceptions.MojaPersonDbException;

import java.util.Arrays;

public class PersonMain {
    public static void main(String[] args) {
//        Person[] persons = {
//          new Person("Janko"),
//          new Person("Peter", 20),
//          new Person("Michaela", 250),
//          new Student("Marian", "12345"),
//          new Student("Robert", 99, "65532"),
//          new Employee("Robert", 99, "master mega chief")
//        };
        Person[] persons = {};
        PersonDatabaseReader reader = new PersonDatabaseReader();

        try {
            persons = reader.readPersonsFromDb();
        } catch (MojaPersonDbException e) {
            System.out.println(e.getMessage());
        }

        persons[4].setCar(new Car("Toyota"));
        persons[5].setCar(new Car("BMW"));

        Arrays.sort(persons);

        for (Person person : persons) {
            person.setAge(300); //NIE
            System.out.println(person.toString()); //person.toString()
        }

//        System.out.println(Person.JAHODA);

//        Person p1 = new Person("Jan");
//        Person p2 = p1;
//        p2.setName("Peter");
//        System.out.println(p1);
//        System.out.println(p2);

//        Student s1 = new Student("Matej", "384709");
//        System.out.println(s1 instanceof Student);
//        System.out.println(s1 instanceof Person);
//        System.out.println(s1 instanceof Object);

//        Car c1 = new Car("BMW");
//        Truck c2 = new Truck("BMW");
//        Car c3 = new PersonalCar("BMW", 3);
//        persons[3].setCar(c1);
//        persons[4].setCar(c2);
//        persons[7].setCar(c3);
//          c2.load("Jahody");
//
//        for (Person p: persons) {
//            if(p.getCar() != null) {
//
//            }
//            System.out.println(p);
//        }

//        System.out.println(s1);
//        s1.setCar(c);
//        System.out.println(s1);
//        s1.getCar().start();
//        System.out.println(s1);
//        s1.getCar().stop();
//        System.out.println(s1);
//        System.out.println(s1.getClass());
    }
}
