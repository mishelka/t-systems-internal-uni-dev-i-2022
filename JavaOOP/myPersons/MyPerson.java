package myPersons;

public class MyPerson {
    private String name;
    private int age;

    public MyPerson(String name) {
        this(name, 0);
        this.name = name;
    }

    public MyPerson(String name, int age) {
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
