package classload.defineclassloader;

import java.lang.reflect.Method;

public class DiskClassLoaderTest {
    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader("D:\\classloader");
        try {
            Class<?> c = diskClassLoader.loadClass("classload.defineclassloader.SayTest");
            if (c != null){
                Method say = c.getDeclaredMethod("say", null);
                Object obj = c.newInstance();
                say.invoke(obj,null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
