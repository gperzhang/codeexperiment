package pattern.singleton.threadlocal;

import java.util.Random;

/**
 * ThreadLocal 以空间换时间的方式，不能保证全局唯一，但是能
 * 保证线程内唯一，而且是线程安全的，线程内的注册式单例
 * @author zj
 * @date 2019-09-25
 */
public class ThreadLocalSington {
    private static ThreadLocal<ThreadLocalSington> threadLocal
            = new ThreadLocal<ThreadLocalSington>();


    private ThreadLocalSington(){}

    public static ThreadLocalSington getInstance(){
        ThreadLocalSington sington = threadLocal.get();
        if(sington == null){
            sington = new ThreadLocalSington();
            threadLocal.set(sington);
        }
        return sington;
    }

    private String msg;

    private String getMsg(){
        return this.msg;
    }

    private void setMsg(String msg){
        this.msg = msg;
    }

    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            ThreadLocalSington.getInstance().setMsg("hhh");
//            System.out.println(Thread.currentThread().getName()+": put data:hhh");
//            System.out.println(Thread.currentThread().getName()+"get data:"+ThreadLocalSington.getInstance().getMsg());
//        },"T1");
//
//        Thread t2 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName()+"get data:"+ThreadLocalSington.getInstance().getMsg());
//        },"T2");
//        t1.start();
//        t2.start();

        for(int i=0;i<2;i++){
            new Thread(() -> {
                int data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName()+" put data:"+data);
                ThreadLocalSington.getInstance().setMsg(data+"");
                System.out.println(Thread.currentThread().getName()+" take data:"+ThreadLocalSington.getInstance().getMsg());
            },"T"+i).start();
        }

    }

}
