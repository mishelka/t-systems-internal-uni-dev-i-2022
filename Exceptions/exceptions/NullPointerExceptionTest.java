package exceptions;

public class NullPointerExceptionTest {
    private static String s;

    public NullPointerExceptionTest(String s) {
        makeLowerCase();
    }

    private void makeLowerCase() {
        s = s.toLowerCase();
        System.out.println(s);
    }

    public static void main(String[] args) {
        new NullPointerExceptionTest("Jaro");
    }
}
