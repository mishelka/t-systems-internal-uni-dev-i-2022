package regex;

public class StringMatchesRegex {
    public static void main(String[] args) {
        final String regex = "\\d{6}/\\d{3,4}";
        final String s = "123456/7890";

        System.out.println(s.matches(regex));
    }
}
