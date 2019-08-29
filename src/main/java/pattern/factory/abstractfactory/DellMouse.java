package pattern.factory.abstractfactory;

public class DellMouse implements Mouse {
    @Override
    public void sayMouse() {
        System.out.println("抽象工厂：戴尔工厂出品鼠标");
    }
}
