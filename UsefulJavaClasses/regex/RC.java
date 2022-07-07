package regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RC {
    private static Pattern RC_PATTERN = Pattern.compile("(\\d{2})[\\. -]?(\\d{2})[\\. -]?(\\d{2})[\\./-]?(\\d{3,4})");
    
    private final String value;
    
    private final Date date;
    
    private final boolean female;
    
    public RC(String value) {
        this.value = value;

        Matcher matcher = RC_PATTERN.matcher(value);
        if(matcher.matches()) {
            String yearString = matcher.group(1);
            String monthPartString = matcher.group(2);
            String monthString = monthPartString;
            String dayString = matcher.group(3);
            String rest = matcher.group(4);
            int month = Integer.parseInt(monthString);
            
            if(month > 50) {
                monthString = String.valueOf(month - 50);
                this.female = true;
            } else {
                this.female = false;
            }
            
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("d.M.y");
                sdf.setLenient(false);
                this.date = sdf.parse(dayString + "." + monthString + "." + yearString);
            } catch (ParseException ex) {
                throw new RuntimeException("Wrong RC date " + getValue());
            }
            
            long number = Long.parseLong(yearString + monthPartString + dayString + rest);
            if(number % 11 != 0) {
                throw new RuntimeException("Wrong RC number by division " + getValue());
            }
        } else {
            throw new RuntimeException("Wrong RC format " + getValue());
        }
    }
    
    public String getValue() {
        return value;
    }
    
    public Date getDate() {
        return date;
    }
    
    public boolean isFemale() {
        return female;
    }

    public String toString() {
        return getValue();
    }    
}
