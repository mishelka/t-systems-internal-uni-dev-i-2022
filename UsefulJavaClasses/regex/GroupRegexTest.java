package regex;

import java.util.regex.*;

public class GroupRegexTest {
    public static void main(String[] args) {
        final String regex = "(\\d{2})(\\d{2})(\\d{2})/(\\d{3,4})";
        final String s = "123456/7890";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.printf("Group %d has content %s\n", i, matcher.group(i));
            }
        }
    }
}
