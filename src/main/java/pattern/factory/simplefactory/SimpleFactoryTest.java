package pattern.factory.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new MouseFactory();
//        mouseFactory.createMouse("dell").say();

        mouseFactory.createMouse("hp").say();
    }
}
