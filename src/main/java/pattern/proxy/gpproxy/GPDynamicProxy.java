package pattern.proxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @author zj
 * @date 2019-10-06
 */
public class GPDynamicProxy implements GPInvocationHandler {

    private Object target;

    public Object getInstance(Object target){
        try {
            this.target = target;
            Class<?> clazz = target.getClass();
            Object proxyObj = GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
            return proxyObj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理之前");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理之后");
        return invoke;
    }
}
