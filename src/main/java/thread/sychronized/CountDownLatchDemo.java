package thread.sychronized;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable {
    static CountDownLatch countDownLatch = new CountDownLatch(10);
    static CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("check complete.....");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            executorService.execute(countDownLatchDemo);
        }
//        try {
//            countDownLatch.await();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("after all check");
    }
}
