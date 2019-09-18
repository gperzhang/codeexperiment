package base.innerclass;

/**静态内部类和非静态内部内都是在被调用的时候才会被加载
 * @author zj
 * @date 2019-09-18 13:43
 */
public class OuterClass {
    static{
        System.out.println("outer class static load");
    }
    public OuterClass(String flag){
        System.out.println("flag："+flag);
    }
    class InnerClass{
        {
            System.out.println("InnerClass load");
        }
        private OuterClass out = new OuterClass("inner");
    }
    static class InnerStaticClass{

        static {
            System.out.println("InnerStaticClass static load");
        }
        private static OuterClass out = new OuterClass("innerStatic");
    }

    public static OuterClass getInstance(){
         return InnerStaticClass.out;
    }
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("HELLO");
        OuterClass.getInstance();
//        InnerClass innerClass = outerClass.new InnerClass();
    }
}
