package pattern.singleton.hungry;

/**
 * 饿汉式就是类一加载就会创建对象
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public HungrySingleton getInstance(){
        return hungrySingleton;
    }
}


class HungrySingleton1{
    private static  HungrySingleton1 hungrySingleton1 = null;

    static {
        hungrySingleton1 = new HungrySingleton1();
    }
    private HungrySingleton1(){}

    public HungrySingleton1 getInstance(){
        return hungrySingleton1;
    }
}
