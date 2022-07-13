
public class NumberStringConversion {
    public static void main(String[] args) {
        System.out.println(
                Integer.MIN_VALUE + " " +
                        Integer.MAX_VALUE
        );
        int i = Integer.parseInt("1243");
        String s = String.valueOf(i);
    }
}
