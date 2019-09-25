package classload;

/**内部类只有在被调用的时候才会初始化，
 * 类的静态代码块、静态属性的加载顺序是跟代码本身的顺序相关的
 * @author zj
 * @date 2019-09-25 13:59
 */
public class Singleton {

        public static class Inner{
            static {
                System.out.println("TestInner Static!");
            }
            public final static Singleton testInstance = new Singleton(3);
        }

        public static Singleton getInstance(){
            return Inner.testInstance;
        }

        public Singleton(int i ) {
            System.out.println("Test " + i +" Construct! ");
        }

        //类静态块
        static {
            System.out.println("Test Static");
        }

        //类静态属性
        public static Singleton testOut = new Singleton(1);

        public static void main(String args[]){
            Singleton t = new Singleton(2);
            Singleton.getInstance();
        }


}
