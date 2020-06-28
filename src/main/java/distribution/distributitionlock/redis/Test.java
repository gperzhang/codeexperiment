package distribution.distributitionlock.redis;


import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    private static Integer inventory = 1001;

    static CountDownLatch count = new CountDownLatch(100);
    static RedisLock redisLock = new RedisLock();

    static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(100,100, 0,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            threadPoolExecutor.execute(()->{
//                String id = UUID.randomUUID().toString();
                redisLock.Lock(UUID.randomUUID().toString());
                inventory--;
                redisLock.unLock(UUID.randomUUID().toString());
                count.countDown();
            });

        }

        try {
            count.await();
            System.out.println("扣减完毕，剩余库存为"+inventory);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }
}
