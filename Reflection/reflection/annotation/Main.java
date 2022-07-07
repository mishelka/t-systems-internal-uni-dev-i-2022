package reflection.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {
    private static final String url = "jdbc:jtds:sqlserver://localhost/skola;tds=8.0;lastupdatecount=true";

    private static final String driver = "net.sourceforge.jtds.jdbc.Driver";

    private static final String user = "";

    private static final String password = "";

    public static void main(String[] args) throws Exception {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);

        DataAccess da = new DataAccess(con);

        // Select
        List<Person> persons = da.select(Person.class, null);
        System.out.println(persons);

        // Insert
        Person p = new Person(100, "Janko", "Hrasko");
        da.insert(p);
        persons = da.select(Person.class, null);
        System.out.println(persons);

        // Update
        p.setFirstName("Vlado");
        da.update(p);
        persons = da.select(Person.class, null);
        System.out.println(persons);

        // Delete
        da.delete(p);
        persons = da.select(Person.class, null);
        System.out.println(persons);
    }
}
