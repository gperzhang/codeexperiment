package pattern.singleton.lazy;

import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 懒汉式 在使用到的时候再创建，有效利用内存空间，但是存在线程安全问题
 */
public class LazySingleton implements Serializable {
    private static LazySingleton lazySingleton =null;
    private LazySingleton(){}

    public static LazySingleton getInstacne(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * 防止序列化破坏单例，但是并不是正在的组织了对象的创建，
     * 只是没有返回新创建的对象而已，如果频繁的创建开销还是很大的
     * @return
     */
    private Object readResolve(){
        return lazySingleton;
    }

}

/**
 * 存在线程安全问题，于是上synchronized
 */
class LazySingleton1 implements Cloneable{
    private static LazySingleton1 lazySingleton1 = null;

    private LazySingleton1(){}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static synchronized LazySingleton1 getInstance(){
        if (lazySingleton1 == null){
            lazySingleton1 = new LazySingleton1();
        }
        return lazySingleton1;
    }

}

/**
 * 然而直接在方法上加锁粒度比较大，可以通过在代码块中加,这样多线程在争抢的时候起码还能进方法getInstance，
 */
class  LazySingleton2{
    private LazySingleton2 lazySingleton2 = null;

    private LazySingleton2(){}

    public LazySingleton2 getInstance(){

        synchronized (LazySingleton2.class){
            if (lazySingleton2 == null){
                lazySingleton2 = new LazySingleton2();
            }
        }
        return lazySingleton2;
    }

}

/**
 * 上面的方法虽然在方法内加锁，但是每次都需要执行到锁检查，就会存在不必要的开销，所以就出现了double check
 */
class  LazySingleton3{
    private static LazySingleton3 lazySingleton3 = null;

    /**
     * 防止反射破坏单例
     */
    private LazySingleton3(){
        if (lazySingleton3 != null){
            throw new RuntimeException("不允许创建多个实例对象");
        }
    }

    public static LazySingleton3 getInstacne(){
        if(lazySingleton3 == null){   //这个判断就是为了减少不必要的执行到synchronized
            synchronized (LazySingleton3.class){
                if(lazySingleton3 ==null){
                    lazySingleton3 = new LazySingleton3();
                }
            }
        }
        return lazySingleton3;
    }
//    private Object readResolve(){
//        return lazySingleton3;
//    }


}