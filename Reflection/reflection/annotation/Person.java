package reflection.annotation;

@Table(name = "student")
public class Person {
    @Column(name = "id", primaryKey = true)
    private int id;

    @Column(name = "meno")
    private String firstName;

    @Column(name = "priezv")
    private String lastName;

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }

    public Person() {
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
