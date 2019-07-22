package pattern.decorator;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("hello:我是Greeting的实现类");
    }
}
