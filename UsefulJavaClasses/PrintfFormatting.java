
import static java.lang.System.out;

public class PrintfFormatting {
    public static void main(String[] args) {
        out.printf("Remaining account balance: $%(,6.2f (Today's total balance: $%(,<8.2f)%n", 1200f);
        out.printf("Date: %tD%nTime: %<tr%n", System.currentTimeMillis());
        out.printf("Words:%n%8s%n%8s%n%8s%n", "One", "Two", "Three");
    }
}
