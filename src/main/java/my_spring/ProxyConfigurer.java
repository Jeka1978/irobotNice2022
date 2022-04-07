package my_spring;

/**
 * @author Evgeny Borisov
 */
public interface ProxyConfigurer {
    Object wrapWithProxy(Object t);
}
