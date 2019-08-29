package pattern.factory.simplefactory;

public class DellMouse implements Mouse {
    @Override
    public void say() {
        System.out.println("我是戴尔工厂生产出来的鼠标");
    }
}
