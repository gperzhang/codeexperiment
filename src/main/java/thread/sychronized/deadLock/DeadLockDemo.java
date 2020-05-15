package thread.sychronized.deadLock;

/**
 * Created by zj on 2020-05-15
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(()->{
            synchronized (lock1){

                System.out.println("获取lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){

                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                System.out.println("获取lock2");
                synchronized (lock1){
                    System.out.println("");
                }
            }
        }).start();
    }
}
