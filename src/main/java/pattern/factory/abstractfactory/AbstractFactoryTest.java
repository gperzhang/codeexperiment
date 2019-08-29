package pattern.factory.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        PcFactory factory = new DellPcFactory();
        PcFactory factory1 = new HpPcFactory();

        factory.createMouse().sayMouse();
        factory.creatKeyBoard().sayKeyBoard();

        factory1.creatKeyBoard().sayKeyBoard();
        factory1.createMouse().sayMouse();
    }
}
