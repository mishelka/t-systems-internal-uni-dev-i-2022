package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IOTestException {
    static class MyException extends Exception { }

    public static void main(String[] args) {
        try {
            throw new MyException();
        } catch (MyException ex) {
            Logger.getLogger(IOTestException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
