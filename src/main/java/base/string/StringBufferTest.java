package base.string;


/**
 * Created by zj on 2019-10-08
 */
public class StringBufferTest {
    public static void main(String[] args) {
       MeString meString = new MeString();
        System.out.println(meString.hashCode());
        System.out.println(meString.getCount());

        meString.append("abc");
        System.out.println(meString.hashCode());
        System.out.println(meString.getCount());

    }
}
