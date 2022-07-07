package reflection;

import java.lang.reflect.Method;

public class ExecuteMethod {
    public static void main(String[] args) throws Exception {
        String name = "reflection.Point";
        Class<?> clazz = Class.forName(name);
        Object object = clazz.newInstance();

        //Execute method with reflection
        Method method = clazz.getMethod("move", Integer.TYPE, Integer.TYPE);
        method.invoke(object, 4, 5);
        System.out.println(object);
    }
}
