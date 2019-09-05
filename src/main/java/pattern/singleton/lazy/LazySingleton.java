package pattern.singleton.lazy;

/**
 * 懒汉式 在使用到的时候再创建，有效利用内存空间，但是存在线程安全问题
 */
public class LazySingleton {
    private LazySingleton lazySingleton =null;
    private LazySingleton(){}

    public LazySingleton getInstacne(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}

/**
 * 存在线程安全问题，于是上synchronized
 */
class LazySingleton1{
    private LazySingleton1 lazySingleton1 = null;

    private LazySingleton1(){}

    public synchronized LazySingleton1 getInstance(){
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
    private LazySingleton3 lazySingleton3 = null;

    private LazySingleton3(){}

    public LazySingleton3 getInstacne(){
        if(lazySingleton3 == null){   //这个判断就是为了减少不必要的执行到synchronized
            synchronized (LazySingleton3.class){
                if(lazySingleton3 ==null){
                    lazySingleton3 = new LazySingleton3();
                }
            }
        }
        return lazySingleton3;
    }

}