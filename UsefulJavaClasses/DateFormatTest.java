
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {
    public static void main(String[] args) {
        //Locale setting
        //Locale.setDefault(Locale.ENGLISH);

        Date date = new Date(1657711149988L);
        System.out.println(date.getTime());
        System.out.println(date);

        DateFormat df = DateFormat.getInstance();

        //Converting Date to String
        String s = df.format(date);
        System.out.println(s);

        s = df.getDateInstance(DateFormat.LONG)
                .format(date);
        System.out.println(s);

        s = df.getTimeInstance()
                .format(date);
        System.out.println(s);

        //Converting String to Date
        try {
            df = new SimpleDateFormat("dd.MM.yyyy");
            date = df.parse("3.12.2006");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
