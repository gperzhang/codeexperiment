package pattern.singleton.lazy;

public class CloenableTest {
    public static void main(String[] args) {
        LazySingleton1 instance1 = LazySingleton1.getInstance();

        try {
            Object clone = instance1.clone();
            System.out.println(clone==instance1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
