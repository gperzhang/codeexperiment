package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {

    private List<Observerable> list = new ArrayList<>();

    @Override
    public void regiesterObj(Observerable observerable) {
        list.add(observerable);
    }
    public void notifyObserver(){
        for(int i=0;i<list.size();i++){
            list.get(i).sendMsg("nihao");
        }
    }

    public static void main(String[] args) {
        User user = new User();
        Observerable o = new WechatService();
        // 注册被观察者
        user.regiesterObj(o);
        // 实际执行还是别观察者对象执行，主要就是用来做解耦用的，是一个代理
        user.notifyObserver();
    }
}
