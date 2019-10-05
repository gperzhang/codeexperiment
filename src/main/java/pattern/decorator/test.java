package pattern.decorator;


public class test {
    public static void main(String[] args) {
        Greeting decoratorGreeting = new BeforeDecorator(new AfterDecorator(new GreetingImpl()));
        decoratorGreeting.sayHello();
//        Integer a = 100;
//        Integer b = 100;
//        Long c = 200L;
//        System.out.println(c==(a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println();
    }
}
