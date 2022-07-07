package jdbc;

import java.sql.*;

//java -cp ../lib/hsqldb.jar org.hsqldb.Server -database.0 file:../data/school -dbname.0 school
public class SelectTest {
    public static final String DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
    public static final String URL = "jdbc:derby://localhost/school";
    public static final String USER = "SA";
    public static final String PASSWORD = "SA";

    public static final String QUERY = "SELECT id, firstname, surname FROM student";
    
    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER_CLASS);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);

        while(rs.next()) {
            System.out.printf("%4d %-32s %-32s%n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}
