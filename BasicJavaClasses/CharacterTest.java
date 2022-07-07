public class CharacterTest {
    public static void main(String[] args) {
        char c = 'a';

        System.out.println("isDigit = " + Character.isDigit(c));    //false
        System.out.println("isLetter = " + Character.isLetter(c));  //true
        System.out.println("isLowerCase = " + Character.isLowerCase(c));    //true
        System.out.println("isUpperCase = " + Character.isUpperCase(c));    //false
        System.out.println("isWhitespace = " + Character.isWhitespace(c));  //false

        System.out.println("toUpperCase = " + Character.toUpperCase(c));    //A
    }
}
