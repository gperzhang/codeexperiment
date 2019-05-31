package Thread.sychronized;

public class SychronizedDemo {

    private String obj;
    public  SychronizedDemo(String obj){
        this.obj=obj;
    }

        public synchronized void m1()  {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(obj+":m1 方法");
        }
        public synchronized void m2(){
            System.out.println(obj+" :m2 方法");
        }

        public static void main(String[] args) throws InterruptedException {
           final SychronizedDemo threadDemo = new SychronizedDemo("对象1");
           final SychronizedDemo threadDemo1 = new SychronizedDemo("对象2");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo.m1();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadDemo1.m1();
                }
            }).start();
        }
    }

