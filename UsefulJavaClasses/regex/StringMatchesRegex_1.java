package regex;

public class StringMatchesRegex_1 {
    public static void main(String[] args) {
        final String regex = "#.*\n";
        final String s = "#123456/7890\n";

        System.out.println(s.matches(regex));
    }
}
