package pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterSingleton {
    private Map<String,Object> cacheMap = new ConcurrentHashMap<String, Object>();

    private RegisterSingleton(){}

    private RegisterSingleton registerSingleton;

    public Object getInstance(String className){

        synchronized (cacheMap) {
            if (!cacheMap.containsKey(className)){
                try {
                    Object instance = Class.forName(className).newInstance();
                    cacheMap.put(className,instance);
                } catch (Exception e) {
                   e.printStackTrace();
                 }
            }
        }
        return cacheMap.get(className);
    }
}
