package pattern.factory.abstractfactory;

public class DellKeyBoard implements KeyBoard {
    @Override
    public void sayKeyBoard() {
        System.out.println("抽象工厂：戴尔工厂出品键盘");
    }
}
