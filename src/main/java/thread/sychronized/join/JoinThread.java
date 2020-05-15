package thread.sychronized.join;

/**
 * Created by zj on 2019-12-16
 */
public class JoinThread extends Thread {


    private String name;

    public JoinThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        System.out.println(l);
    }
}
