package my_spring;

import lombok.SneakyThrows;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    public static ObjectFactory getInstance() {

        return instance;
    }





    @SneakyThrows
    public <T> T createObject(Class<T> type) {

        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();


        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                Random random = new Random();
                int min = annotation.min();
                int max = annotation.max();

                int value = random.nextInt(max - min) + min + 1;

                field.setAccessible(true);
                field.set(t,value);






            }
        }



        return t;

    }
}








