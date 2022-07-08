package temp;

import sk.tuke.examples.Person;

public class Temp {
    public static void main(String[] args) {
        Person p = new Person("Miska", "Bacikova");
        //p.firstName; //nejde, lebo je private
        p.getFirstName(); //ide lebo je public
    }
}
