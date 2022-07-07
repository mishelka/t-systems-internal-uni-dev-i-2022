package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DescribeClass {
    public static void main(String[] args) throws Exception {
        //Creates instance of a class
        String className = "reflection.Point";
        Class<?> clazz = Class.forName(className);
        
        System.out.println("Class: " + clazz.getCanonicalName());
        System.out.println("Superclass: " + clazz.getSuperclass());
        
        System.out.println("Interfaces:");
        for(Class ifClass : clazz.getInterfaces()) {
            System.out.println("  " + ifClass.getCanonicalName());
        }
        
        System.out.println("Constructors:");
        for(Constructor constructor : clazz.getConstructors()) {
            System.out.println("  " + constructor);
        }

        System.out.println("Declared fields:");
        for(Field field : clazz.getDeclaredFields()) {
            System.out.println("  " + field);
        }
        
        System.out.println("Declared methods:");
        for(Method method : clazz.getDeclaredMethods()) {
            System.out.println("  " + method);
        }

        System.out.println("Fields:");
        for(Field field : clazz.getFields()) {
            System.out.println("  " + field);
        }

        System.out.println("Methods:");
        for(Method method : clazz.getMethods()) {
            System.out.println("  " + method);
        }
    }
}
