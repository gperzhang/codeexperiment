package thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
//        for(int i=0;i<10;i++){
//           final int index = i;
//           scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
//               @Override
//               public void run() {
//                   System.out.println("定时执行任务"+index);
//                   try {
//                       Thread.sleep(1000);
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
//
//               }
//           },1L,3000L,TimeUnit.MILLISECONDS);
//        }




            //  等上一个任务执行完成之后再去执行
//            scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("定时执行任务");
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            },1L,3000L,TimeUnit.MILLISECONDS);

        // 跟上一个任务执行开始时间间隔
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时执行任务时间");
                long time = System.currentTimeMillis();
                try {
                    Thread.sleep(10000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        },1L,1000L,TimeUnit.MILLISECONDS);

    }
}
