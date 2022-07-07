
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) {
        //Locale setting
        //Locale.setDefault(Locale.ENGLISH);

        Date date = new Date();
        DateFormat df = DateFormat.getInstance();

        //Converting Date to String
        String s = df.format(date);
        System.out.println(s);

        s = df.getDateInstance(DateFormat.LONG).format(date);
        System.out.println(s);

        s = df.getTimeInstance().format(date);
        System.out.println(s);

        //Converting String to Date
        try {
            date = df.getDateInstance().parse("3.12.2006");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
