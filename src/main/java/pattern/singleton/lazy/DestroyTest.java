package pattern.singleton.lazy;

import pattern.singleton.lazy.LazySingleton3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射破坏单例
 */
public class DestroyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Object instacne = LazySingleton3.getInstacne();
        Class<?> clazz = LazySingleton3.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object newInstance = constructor.newInstance();
        System.out.println(instacne==newInstance);


    }
}
