package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurer> configurers = new ArrayList<>();


    @SneakyThrows
    public ObjectFactory() {
        Reflections scanner = new Reflections("my_spring");
        Set<Class<? extends ObjectConfigurer>> set = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : set) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static ObjectFactory getInstance() {

        return instance;
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {

        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        for (ObjectConfigurer configurer : configurers) {
            configurer.configure(t);
        }

        return t;

    }
}








