
import java.util.Date;
import java.util.Formatter;

public class Examples {
    public static void main(String[] args) {
        String s = "7";
        int i = Integer.parseInt(s);

        s = "7.6";
        double d = Double.parseDouble(s);

        String s1 = "jahoda";
        String s2 = "jahoda";
        s1 += s2;
        s1 = s1 + s2;
        String s3 = s1 + s2;
    }
}
