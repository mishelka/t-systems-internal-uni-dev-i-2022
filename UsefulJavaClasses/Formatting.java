
import java.util.Date;
import java.util.Formatter;

public class Formatting {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("Remaining account balance: $%,.2f", 1200000.50);
        System.out.println(formatter.toString());

        formatter = new Formatter(System.out);
        formatter.format("Today is %tA, %<td. %<tB %<tY", new Date());
    }
}
