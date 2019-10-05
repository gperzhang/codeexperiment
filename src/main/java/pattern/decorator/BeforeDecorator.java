package pattern.decorator;

public class BeforeDecorator extends DecoratorGreeting {

    public BeforeDecorator(Greeting greeting) {
        super(greeting);
    }
    public void sayHello(){
        System.out.println("Before");
        this.greeting.sayHello();
    }
}
