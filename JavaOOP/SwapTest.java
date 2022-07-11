public class SwapTest {
    public static void main(String[] args) {
        int a = 4; //5 after swap
        int b = 5; //4 after swap
        SwapTest.swap(a, b);
        System.out.println("a: " + a + ", b: " + b);
    }

    //!NOT POSSIBLE IN JAVA - PRIMITIVE VALUE!
    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
