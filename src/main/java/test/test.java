package test;

import thread.clone.User;

public class test {
    public static void main(String[] args) {
        User user = new User();
        user.setName("zhangjie");
        user.setAge("17");
        TransferObj transferObj = new TransferImpl();
        transferObj.excute(user);
    }
}
