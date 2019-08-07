package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void push(int msg){
        executorService.execute(() -> {
            Byte [] bytes = new Byte[1024*1024*8];
            System.out.println(Thread.currentThread().getName()+"任务放到线程池"+msg);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            System.out.println("第"+i+"次塞数据开始");
            push(i);
            System.out.println("第"+i+"次塞数据结束");
        }
    }
}
