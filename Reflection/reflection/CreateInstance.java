package reflection;

import java.lang.reflect.Constructor;

public class CreateInstance {
    public static void main(String[] args) throws Exception {
        //Creates instance of a class
        String className = "reflection.Point";
        Class<?> clazz = Class.forName(className);        
        System.out.println(clazz.getCanonicalName());
        
        //Using constructor: Point()
        Object o = clazz.newInstance();        
        System.out.println(o + " " + o.getClass().getCanonicalName());
        
        //Using constructor: Point(int x, int y)
        Constructor<?> constructor = clazz.getConstructor(Integer.TYPE, Integer.TYPE);
        o = constructor.newInstance(2, 3);
        System.out.println(o + " " + o.getClass().getCanonicalName());
    }
}
