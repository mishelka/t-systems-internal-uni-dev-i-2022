package exceptions;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingTest {
     public static void main(String[] args) throws Exception {
          Handler handler = new FileHandler("c:/error.log");
          Logger.getLogger("").addHandler(handler);

          String s = "1234s";
          try {
               int i = Integer.parseInt(s);
               System.out.println(i);
          } catch (NumberFormatException e) {
               Logger.getLogger(LoggingTest.class.getName()).
                       log(Level.SEVERE,
                       "Cannot parse number: " + s);
          }
     }
}
