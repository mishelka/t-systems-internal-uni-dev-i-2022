package jdbc.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PoolTest {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();

        Connection connection = pool.acquire();
        try {
            connection = pool.acquire();

            //Do something
            selectTest(connection);

            pool.release(connection);
        } catch (Exception e) {
            pool.error(connection);
        }
    }

    private static void selectTest(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, firstname, surname FROM student");

        while (rs.next()) {
            System.out.printf("%4d %-32s %-32s%n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }

        rs.close();
        stmt.close();
    }
}
