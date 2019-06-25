package thread.sychronized;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;

    public CyclicBarrierDemo(CyclicBarrier cyclicBarrier,String name){
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000*(new Random()).nextInt(8));
            System.out.println(name+":准备ok");
            cyclicBarrier.await();
            System.out.println(name+":GO GO GO");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService  executor = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            executor.submit(new CyclicBarrierDemo(cyclicBarrier,"第"+i+"个选手"));
        }
//        executor.submit(new CyclicBarrierDemo(cyclicBarrier,"xiaoming"));
//        executor.submit(new CyclicBarrierDemo(cyclicBarrier,"xiaoli"));
//        executor.submit(new CyclicBarrierDemo(cyclicBarrier,"xiaogou"));
//        executor.submit(new CyclicBarrierDemo(cyclicBarrier,"xiaowang"));
//        executor.submit(new CyclicBarrierDemo(cyclicBarrier,"xiaohong"));
        executor.shutdown();
    }
}
