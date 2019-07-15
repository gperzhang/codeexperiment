package test;

import thread.clone.User;

import java.text.SimpleDateFormat;

public class test {
    public static void main(String[] args) {
//        User user = new User();
//        user.setName("zhangjie");
//        user.setAge("17");
//        TransferObj transferObj = new TransferImpl();
//        transferObj.excute(user);
        String date = "2019-07-12T06:59:43+08:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println(format);
    }
}
