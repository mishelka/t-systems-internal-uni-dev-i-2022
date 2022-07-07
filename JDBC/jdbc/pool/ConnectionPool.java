package jdbc.pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    protected static final String DATABASE_PROPERTIES = "database.properties";

    private Connection connection;

    private String driverClass;

    private String url;

    private String user;

    private String password;

    public ConnectionPool() {
        loadProperties();
    }

    public Connection acquire() {
        if (connection == null) {
            create();
        }
        return connection;
    }

    public void release(Connection connection) {
    }

    public void error(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            //Do nothing, just drop the connection
        }
        connection = null;
    }

    private void create() {
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Throwable e) {
            throw new ApplicationException(2, "Cannot create database connection, check '" + DATABASE_PROPERTIES + "' file and run the server!", e);
        }
    }

    private void loadProperties() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream(DATABASE_PROPERTIES));
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            throw new ApplicationException(1, "Cannot load database configuration file '" + DATABASE_PROPERTIES + "'", e);
        }
    }
}
