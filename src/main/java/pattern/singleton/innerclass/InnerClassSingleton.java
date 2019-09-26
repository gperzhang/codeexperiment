package pattern.singleton.innerclass;

import java.io.Serializable;

/**
 * 虽说双重检查既能保证单例又能保证线程的安全，但是始终还是用到了锁，就会降低性能
 * 那么有没有更好的单例写法呢？
 */
public class InnerClassSingleton implements Serializable {

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return SingletonHolder.innerClassSingleton;
    }
    private static class SingletonHolder{
        private static final InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

}
