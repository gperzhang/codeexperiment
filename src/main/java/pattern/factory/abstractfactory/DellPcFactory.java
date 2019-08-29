package pattern.factory.abstractfactory;

public class DellPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBoard creatKeyBoard() {
        return new DellKeyBoard();
    }
}
