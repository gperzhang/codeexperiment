package thread.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableFutureTask implements Callable {
    @Override
    public Integer call() throws Exception {
        System.out.println("FutureTask子线程正在计算。。。。");
        int sum =0;
        for (int i=0;i<100;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        CallableFutureTask callableFutureTask = new CallableFutureTask();
        FutureTask<Integer> ftureTask = new FutureTask<Integer>(callableFutureTask);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(ftureTask);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程正在执行。。");
        try {
            if(ftureTask.get()!=null){
                System.out.println("去除执行结果为"+ftureTask.get());
            }else {
                System.out.println("未取到结果。。。");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
