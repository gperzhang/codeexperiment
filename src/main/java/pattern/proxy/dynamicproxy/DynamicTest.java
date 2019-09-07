package pattern.proxy.dynamicproxy;

public class DynamicTest {
    public static void main(String[] args) {

        Person instance = (Person) new DynamicProxy().getInstance(new Son());
        System.out.println(instance);

    }
}
