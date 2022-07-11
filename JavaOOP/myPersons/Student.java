package myPersons;

public class Student extends Person {
    private String isicNumber;
    private String surname;

    public Student(String name, String isicNumber) {
        super(name);
        this.isicNumber = isicNumber;
    }

    public Student(String name, int age, String isicNumber) {
        super(name, age);
        this.isicNumber = isicNumber;
    }

    public String getIsicNumber() {
        return isicNumber;
    }

    public void setIsicNumber(String isicNumber) {
        this.isicNumber = isicNumber;
    }

    @Override
    public String toString() {
        return "STUDENT "
                + super.toString()
                + ", isic: " + isicNumber;
    }
}
