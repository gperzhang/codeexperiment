package pattern.factory.abstractfactory;

public class HpPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard creatKeyBoard() {
        return new HpKeyBoard();
    }
}
