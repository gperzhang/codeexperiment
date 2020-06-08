package thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "yes";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThread createThread = new CreateThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(createThread);
        new Thread(futureTask,"callable线程").start();
        System.out.println("线程返回的值"+futureTask.get());
    }
}
