public class SystemTest {
    public static void main(String[] args) {
        System.out.println("user.name = " + System.getProperty("user.name"));
        System.out.println("user.home = " + System.getProperty("user.home"));
        System.out.println("user.dir = " + System.getProperty("user.dir"));
        System.out.println("os.name = " + System.getProperty("os.name"));

        System.out.println("file.separator = " + System.getProperty("file.separator"));
        System.out.println("path.separator = " + System.getProperty("path.separator"));
    }
}
