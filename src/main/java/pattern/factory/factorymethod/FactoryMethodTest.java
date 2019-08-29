package pattern.factory.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new DellMouseFactory();
        mouseFactory.createMouse().say();    // 戴尔鼠标工厂生产

        MouseFactory mouseFactory1 = new HpMouseFactory();
        mouseFactory1.createMouse().say();   // 惠普鼠标工厂出品
    }
}
