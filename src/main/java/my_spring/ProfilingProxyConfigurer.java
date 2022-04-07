package my_spring;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
public class ProfilingProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object wrapWithProxy(Object t) {
        Class<?> type = t.getClass();
        if (type.isAnnotationPresent(Profiling.class) || Arrays.stream(type.getMethods())
                .anyMatch(method -> method.isAnnotationPresent(Profiling.class))) {

            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (InvocationHandler) (o, method, args) -> {
                    return getInvocationHandler(t, type, method, args);
                });

            } else {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> {
                    return getInvocationHandler(t, type, method, args);
                });

            }

        }
        return t;
    }

    private Object getInvocationHandler(Object t, Class<?> type, Method method, Object[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (classMethod.isAnnotationPresent(Profiling.class) || type.isAnnotationPresent(Profiling.class)) {
            System.out.println("*********** profiling started for method : " + method.getName());
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("*********** profiling ended for method : " + method.getName());
            return retVal;
        } else {
            return method.invoke(t, args);
        }
    }
}
