package pattern.proxy.cglib;

/**
 * @author zj
 * @date 2019-10-05
 */
public class CglibTest {
    public static void main(String[] args) {

        Son s = new Son();
        CglibProxy cglibProxy = new CglibProxy();
        Son instance = (Son) cglibProxy.getInstance(s);
        instance.findLove();
    }
}
