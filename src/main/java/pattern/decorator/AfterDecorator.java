package pattern.decorator;

/**
 * @author zj
 * @date 2019-10-05
 */
public class AfterDecorator extends DecoratorGreeting {
    public AfterDecorator(Greeting greeting) {
        super(greeting);
    }
    public void sayHello(){
        System.out.println("after");
        this.greeting.sayHello();
    }
}
