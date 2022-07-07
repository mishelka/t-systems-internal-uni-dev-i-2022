package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Jozo");
        list.add("Fero");
        list.add("Jano");
        
        //String[] oa = (String[]) list.toArray();
        String[] sa = list.toArray(new String[] {});
        
        List<String> sl = Arrays.asList(sa);
        
        System.out.println(sl);
    }
}
