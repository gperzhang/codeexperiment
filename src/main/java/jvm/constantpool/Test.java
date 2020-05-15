package jvm.constantpool;


import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**运行时常量池存在于方法区中，字符串常量池在1.7之前也存在于方法区中，1.7的时候被放到堆中
 * @author zj
 * @date 2019-09-18 10:12
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

//            String str = "abc";
//            char[] arrays = {'a', 'b', 'c'};
//            String str2 = new String(arrays);
//            str2 = str2.intern();
//            System.out.println(str == str2);
//
//            ArrayList<String> list = new ArrayList<>();
//            for (int i = 0; i < 100000000; i++) {
//                for (int j = 0; j < 1000000; j++) {
//                    list.add(String.valueOf(i + j /1000000).intern());
//                }
//            }
        Runtime runtime = Runtime.getRuntime();
        long l = runtime.freeMemory();
        System.out.println("初始内存大小"+l);

        List<String> list = new ArrayList<>();

        Thread.sleep(1000);
        System.out.println("创建一个空的arraylist对象后内存大小"+runtime.freeMemory());
        for(int i=0;i<100;i++){
            list.add(new String("abc"+i).intern());
        }

        System.out.println(""+runtime.freeMemory());
    }



}
