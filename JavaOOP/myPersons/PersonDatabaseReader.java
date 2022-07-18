package myPersons;

import myPersons.exceptions.MojaPersonDbException;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

public class PersonDatabaseReader {
    Connection dbConnection;

    public Person[] readPersonsFromDb() throws MojaPersonDbException {
        try {
            //db connect
            dbConnection.createStatement(/*"SELECT * FROM person"*/);
            dbConnection.commit();
            return new Person[]{};
//        } catch(ConnectException e) {
//            throw new MojaPersonDbException("CHYBA PRI PRIPOJENI NA DATABAZU");
        } catch(SQLException e) {
            throw new MojaPersonDbException("CHYBA PRI COMMITE");
        }
    }
}
