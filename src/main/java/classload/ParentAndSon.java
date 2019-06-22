package classload;

public class ParentAndSon {
    public static void main(String[] args) {
        Parent s = new Son();
        s.method();
        System.out.println(s.add);
        Parent s1 = new Parent();
        s1.method();
        Son son = new Son();
        System.out.println(son.add);
    }
}
