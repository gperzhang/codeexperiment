package pattern.factory.factorymethod;

public class DellMouse implements Mouse {
    @Override
    public void say() {
        System.out.println("工厂方法：戴尔鼠标工厂出品");
    }
}
