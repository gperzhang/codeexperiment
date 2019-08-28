package pattern.observer;

public class WechatService implements Observerable {
    @Override
    public void sendMsg(String str) {
        System.out.println("我是被观察者对象："+str);
    }
}
