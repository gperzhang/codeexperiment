package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSinglePool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    if(index ==5){
                        throw new IllegalStateException("error");
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            });
            Thread.sleep(1000);

        }
        singleThreadExecutor.shutdown();
    }
}
