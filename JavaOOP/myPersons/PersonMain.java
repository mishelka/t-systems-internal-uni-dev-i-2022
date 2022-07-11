package myPersons;

public class PersonMain {
    public static void main(String[] args) {
        Person[] persons = {
          new Person("Janko"),
          new Person("Peter", 20),
          new Person("Michaela", 250),
          new Student("Marian", "12345"),
          new Student("Marina", 99, "65532"),
          new Employee("Robert", 35, "master mega chief")
        };

        for (Person person : persons) {
            person.setAge(300); //NIE
            System.out.println(person.toString()); //person.toString()
        }

//        Person p1 = new Person("Jan");
//        Person p2 = p1;
//        p2.setName("Peter");
//        System.out.println(p1);
//        System.out.println(p2);
    }
}
