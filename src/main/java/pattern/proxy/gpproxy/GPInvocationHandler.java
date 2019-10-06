package pattern.proxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @author zj
 * @date 2019-10-06
 */
public interface GPInvocationHandler {
     Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
