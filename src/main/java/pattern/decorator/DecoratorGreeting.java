package pattern.decorator;

public  class DecoratorGreeting implements Greeting {

    public Greeting greeting;

    public DecoratorGreeting(Greeting greeting){
        this.greeting = greeting;
    }
    @Override
    public void sayHello() {
        this.greeting.sayHello();
    }
}
