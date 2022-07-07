package reflection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Moving {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter class name:");
        String name = reader.readLine();
        
        Class<?> clazz = Class.forName(name);

        //Execute method with reflection
        Object object = clazz.newInstance();
        if(object instanceof Moveable) {
            ((Moveable)object).move(4, 4);
            System.out.println(object);                
        }else {
            System.out.println("Object is not moveable");
        }
    }
}
