package test;

public class TestClass {

    static {

        System.out.println("静态代码块");
    }
    public TestClass(){
        System.out.println("构造方法");
        System.out.println(name);
    }
    {
        System.out.println("普通代码块");
    }

    private static String name = "zhangjie";
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
    }
}
