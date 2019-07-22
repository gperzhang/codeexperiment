package pattern.decorator;

public class ConcretDecorator extends DecoratorGreeting {

    public ConcretDecorator(Greeting greeting) {
        super(greeting);
    }
    public void sayHello(){
        System.out.println("ready?");
        this.greeting.sayHello();
    }
}
