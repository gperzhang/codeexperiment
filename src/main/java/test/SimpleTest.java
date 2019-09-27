package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zj
 * @date 2019-09-27 14:58
 */
public class SimpleTest {
    public static void main(String[] args) {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        ThreadLocal<SimpleDateFormat> simple = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        for(int i=0;i<20;i++){
            new Thread(() -> {
                SimpleDateFormat simpleDateFormat = simple.get();
                String format = simpleDateFormat.format(new Date());
                try {
                    Date parse = simpleDateFormat.parse(format);
                    String format1 = simpleDateFormat.format(parse);
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"format:"+format+"format1:"+format1+format.equals(format1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            },"线程"+i).start();
        }
    }
}
