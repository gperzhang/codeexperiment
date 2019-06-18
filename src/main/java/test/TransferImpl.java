package test;

import thread.clone.User;

public class TransferImpl implements TransferObj {
    @Override
    public void excute(User user) {
        System.out.println(user);
    }
}
