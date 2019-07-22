package pattern.decorator;


public class test {
    public static void main(String[] args) {
        Greeting decoratorGreeting = new DecoratorGreeting(new GreetingImpl());
        decoratorGreeting.sayHello();
    }
}
