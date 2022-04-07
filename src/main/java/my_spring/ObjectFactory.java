package my_spring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory instance = new ObjectFactory();

    public static ObjectFactory getInstance() {

        return instance;
    }


    public void stam(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().startsWith("xyz")) {
                field.setAccessible(true);
                field.set(o,12);
            }
        }
    }

    public void stam2(String className) throws Exception {
        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        Object o = constructor.newInstance();
    }


    public <T> T createObject(Class<T> type) throws Exception {

        if (type.isInterface()) {

        }

        //todo finish this
        return null;

    }
}






