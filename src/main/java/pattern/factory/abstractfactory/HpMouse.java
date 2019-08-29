package pattern.factory.abstractfactory;

public class HpMouse implements Mouse {
    @Override
    public void sayMouse() {
        System.out.println("抽象工厂：惠普工厂出品鼠标");
    }
}
