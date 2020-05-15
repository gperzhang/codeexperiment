package thread.sychronized.deadLock;


/**
 * Created by zj on 2020-05-15
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
