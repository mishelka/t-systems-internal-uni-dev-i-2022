package jdbc;

import java.sql.*;

//java -cp ../lib/hsqldb.jar org.hsqldb.Server -database.0 file:../data/school -dbname.0 school
public class CreateTest {
    public static final String DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
    public static final String URL = "jdbc:derby://localhost/school";
    public static final String USER = "SA";
    public static final String PASSWORD = "SA";

    public static final String QUERY = "CREATE TABLE student (id INT PRIMARY KEY, firstname VARCHAR(32) NOT NULL, surname VARCHAR(32) NOT NULL)";
    
    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER_CLASS);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = con.createStatement();
        stmt.executeUpdate(QUERY);
        stmt.close();
        con.close();
    }
}
