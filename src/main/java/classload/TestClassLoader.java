package classload;

import sun.misc.Launcher;

public class TestClassLoader {
    public static void main(String[] args) {
      /*  System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));*/
        /*TestClassLoader testClassLoader = new TestClassLoader();
        ClassLoader classLoader = testClassLoader.getClass().getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());//父类加载器为空代表其为根加载器*/
        String s = "com.gupaoedu.com";
        String s1 = "acasa";
        System.out.println(s1.lastIndexOf("."));
        int index = s.lastIndexOf(".");
        System.out.println(s.substring(index+1)+".class");
    }
}