package distribution.distributitionlock.redis;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

    private static Integer inventory = 1001;

    static CountDownLatch count = new CountDownLatch(100);
    static RedisLock redisLock = new RedisLock();

    static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(100,100, 10L,TimeUnit.SECONDS,new LinkedBlockingQueue<>());


    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://106.13.13.244:6379").setPassword("zj123456");
        RedissonClient client = Redisson.create(config);
        RLock lock1 = client.getLock("lock1");

        for (int i=0;i<100;i++){
            threadPoolExecutor.execute(()->{
                lock1.lock();
                inventory--;
                count.countDown();
                System.out.println(count.getCount());
                lock1.unlock();

            });
        }
        try {
            count.await();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("扣减完毕，剩余库存为"+inventory);

        threadPoolExecutor.shutdown();
    }
}
