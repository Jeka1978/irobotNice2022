package my_spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2Impl = new HashMap<>();


    public JavaConfig() {
        ifc2Impl.put(Speaker.class, ConsoleSpeaker.class);
        ifc2Impl.put(Cleaner.class, CleanerImpl.class);
        ifc2Impl.put(NiceService.class, NiceServiceImpl.class);
    }

    @Override
    public <T> Class<T> getImplClass(Class<T> ifc) {
        return ifc2Impl.get(ifc);
    }
}






