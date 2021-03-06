package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
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
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();


    @SneakyThrows
    public ObjectFactory() {
        Reflections scanner = new Reflections("my_spring");
        Set<Class<? extends ObjectConfigurer>> set = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : set) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                configurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
        Set<Class<? extends ProxyConfigurer>> classes = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> aClass : classes) {
            proxyConfigurers.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    public static ObjectFactory getInstance() {

        return instance;
    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {

        type = resolveImpl(type);

        T t = type.getDeclaredConstructor().newInstance();

        configure(t);

        invokeInitMethod(type, t);

        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = (T) proxyConfigurer.wrapWithProxy(t);
        }


        return t;

    }

    private <T> void invokeInitMethod(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        for (ObjectConfigurer configurer : configurers) {
            configurer.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }
        return type;
    }
}








