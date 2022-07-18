package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algoritms {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("John");
        list.add("Alice");
        list.add("Carol");
        list.add("Bob");
        
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        list.remove(3);
    }
}
