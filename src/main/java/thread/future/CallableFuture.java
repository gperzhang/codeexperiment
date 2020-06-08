package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture implements Callable {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算。。。");
        int sum = 0;
        for(int i=0;i<50;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CallableFuture task = new CallableFuture();
        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程正在执行。。");
        try {
            if(result.get()!=null){
                System.out.println("取出执行结果为"+result.get());
            }else {
                System.out.println("未取到结果。。。");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
