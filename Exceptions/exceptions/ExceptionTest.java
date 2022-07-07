package exceptions;

public class ExceptionTest {
    public static void main(String[] args) {
        String s = "1234s";
        try {
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }
    }
}
