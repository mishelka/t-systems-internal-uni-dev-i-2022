package myPersons;

public class Person {
    private String name;
    private int age;

    public Person(String name) {
        this(name, 0);
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        //if not valid, set default age 0
        this.age = age;
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
        //check age, don't set if not valid
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
