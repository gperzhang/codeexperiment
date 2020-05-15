package test.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by zj on 2020-03-09
 */
public class ThreadStatusDemo {

    public static void main(String[] args){
        //
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Timed_Waiting_Thread").start();

        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Waiting_Thread").start();


        new Thread(new BlockedStatus(),"Blocked_Thread01").start();

        new Thread(new BlockedStatus(),"Blocked_Thread02").start();
    }

    static class BlockedStatus extends Thread{

        @Override
        public void run() {
            synchronized (BlockedStatus.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

