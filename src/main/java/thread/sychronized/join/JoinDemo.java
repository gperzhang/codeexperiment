package thread.sychronized.join;

/**
 * Created by zj on 2019-12-16
 */
public class JoinDemo extends Thread {
    private int i;
    private Thread previousThread;

    public JoinDemo(int i,Thread previousThread){
        this.i = i;
        this.previousThread = previousThread;
    }
    @Override
    public void run() {
       try {
           previousThread.join();
       }catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println("num"+i);
    }

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        for(int i=0;i<10;i++){
            JoinDemo joinDemo = new JoinDemo(i, thread);
            joinDemo.start();
            thread = joinDemo;
        }
    }
}
