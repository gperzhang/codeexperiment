package pattern.factory.abstractfactory;

public class HpKeyBoard implements KeyBoard {
    @Override
    public void sayKeyBoard() {
        System.out.println("抽象工厂：惠普出品键盘");
    }
}
