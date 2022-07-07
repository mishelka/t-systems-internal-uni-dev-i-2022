package jdbc;

import java.sql.*;

//java -cp ../lib/hsqldb.jar org.hsqldb.Server -database.0 file:../data/school -dbname.0 school
public class InsertTest {
    public static final String DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
    public static final String URL = "jdbc:derby://localhost/school";
    public static final String USER = "SA";
    public static final String PASSWORD = "SA";

    public static final String QUERY = "INSERT INTO student (id, firstname, surname) VALUES (?, ?, ?)";
    
    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER_CLASS);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement stmt = con.prepareStatement(QUERY);
        stmt.setInt(1, 1);
        stmt.setString(2, "Fero");
        stmt.setString(3, "Hrozny");
        stmt.executeUpdate();
        stmt.close();
        con.close();
    }
}
