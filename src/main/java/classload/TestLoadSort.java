package classload;

public class TestLoadSort {


    public TestLoadSort(){
        System.out.println("构造函数");
        System.out.println("a="+a+",b="+b);
    }

    {
        System.out.println("普通代码块");
    }
    static{
        System.out.println("静态代码块");
    }
    static  TestLoadSort testLoadSort = new TestLoadSort();

    int a = 10;
    static int b =100;

    public static void hello(){
        System.out.println("hello方法");
    }
    public static void main(String[] args) {
        System.out.println("main fangfa");
    }
}
