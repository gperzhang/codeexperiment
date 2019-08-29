package pattern.factory.factorymethod;

public class HpMouse implements Mouse {
    @Override
    public void say() {
        System.out.println("工厂方法：惠普鼠标工厂出品");
    }
}
