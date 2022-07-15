package exceptions;

public class NullPointerExceptionTest {
    private static String s;

    public NullPointerExceptionTest(String s) {
        this.s = s.toLowerCase();
        makeLowerCase();
    }

    private void makeLowerCase() {
        System.out.println(s);
    }

    public static void main(String[] args) {
        new NullPointerExceptionTest("Jaro");
    }
}
