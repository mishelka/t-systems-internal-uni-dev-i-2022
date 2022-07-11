package myPersons;

public class PersonMain {
    public static void main(String[] args) {
        MyPerson[] persons = {
          new MyPerson("Janko"),
          new MyPerson("Peter", 20),
        };

        for (MyPerson person : persons) {
            System.out.println(person);
        }
    }
}
