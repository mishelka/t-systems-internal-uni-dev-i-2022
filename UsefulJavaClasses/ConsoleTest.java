import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console();
        console.printf("Please enter your name: ");
        String name = console.readLine();
        console.printf("Hello %s\n", name);
    }
}
