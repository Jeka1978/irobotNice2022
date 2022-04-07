package my_spring;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class ApplicationContext {


    private Map<Class, Object> singletonCache = new HashMap<>();


    @SneakyThrows
    public <T> T getObject(Class<T> type) {

        if (singletonCache.containsKey(type)) {
            return (T) singletonCache.get(type);
        }else {
            T object = ObjectFactory.getInstance().createObject(type);
            singletonCache.put(type, object);
            return object;
        }
    }

}
