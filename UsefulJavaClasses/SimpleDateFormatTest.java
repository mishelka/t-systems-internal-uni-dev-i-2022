
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        //Converting Date to String
        String s = df.format(date);
        System.out.println(s);

        //Converting String to Date
        try {
            date = df.parse("03-12-2006");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
