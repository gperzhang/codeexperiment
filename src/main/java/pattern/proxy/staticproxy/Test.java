package pattern.proxy.staticproxy;

public class Test {
    public static void main(String[] args) {
        Parent person = new Parent(new Son());
        person.find();
    }
}
