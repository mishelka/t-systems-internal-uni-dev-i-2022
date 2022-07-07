package jdbc;

import java.sql.*;

//java -cp ../lib/hsqldb.jar org.hsqldb.Server -database.0 file:../data/school -dbname.0 school
public class RSMDTest {
    public static final String DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
    public static final String URL = "jdbc:derby://localhost/school";
    public static final String USER = "SA";
    public static final String PASSWORD = "SA";
    
    public static final String QUERY = "SELECT * FROM student";
    
    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER_CLASS);
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column Name: " + rsmd.getColumnName(i));
            System.out.println("Column Type: " + rsmd.getColumnTypeName(i));
        }        
        
        rs.close();
        stmt.close();
        con.close();
    }
}
