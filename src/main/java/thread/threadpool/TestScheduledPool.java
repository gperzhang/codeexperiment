package thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            scheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("定时执行"+Thread.currentThread().getName());
                }
            },1000,TimeUnit.MILLISECONDS);
        }
        scheduledThreadPool.shutdown();
    }
}
