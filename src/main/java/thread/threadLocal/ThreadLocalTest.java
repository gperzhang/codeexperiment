package thread.threadLocal;

/**
 * Created by zj on 2020-05-14
 */
public class ThreadLocalTest {

    static ThreadLocal<User> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

        new Thread(()->{
            threadLocal.set(new User("ZHANGJIE",18));
        }).start();
    }
}
class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
