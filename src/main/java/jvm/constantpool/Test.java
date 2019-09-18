package jvm.constantpool;

import java.util.ArrayList;

/**运行时常量池存在于方法区中，字符串常量池在1.7之前也存在于方法区中，1.7的时候被放到堆中
 * @author zj
 * @date 2019-09-18 10:12
 */
public class Test {
    public static void main(String[] args) {

            String str = "abc";
            char[] arrays = {'a', 'b', 'c'};
            String str2 = new String(arrays);
            str2 = str2.intern();
            System.out.println(str == str2);

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < 100000000; i++) {
                for (int j = 0; j < 1000000; j++) {
                    list.add(String.valueOf(i + j /1000000).intern());
                }
            }
        }



}
