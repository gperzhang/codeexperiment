package jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zj on 2020-05-12
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {

//        String str1 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str1.intern()==str1);
//
//        String str = new StringBuilder("zhang").append("jie").toString();
//        System.out.println(str.intern() == str);

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{

    }
}
