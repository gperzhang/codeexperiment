package pattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicProxy implements InvocationHandler {

    private Object obj;

    public Object getInstance(Object obj){
        this.obj = obj;
        Class<?> clazz = obj.getClass();
        Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

        return proxyInstance;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前");
        Object invoke = method.invoke(obj, args);
        System.out.println("代理之后");
        return invoke;
    }
}
