package pattern.proxy.gpproxy;

/**
 * @author zj
 * @date 2019-10-06
 */
public class GPProxyTest {
    public static void main(String[] args) {
        GPDynamicProxy proxy = new GPDynamicProxy();
        Person instance = (Person) proxy.getInstance(new Son());
        instance.findLove();
    }
}
