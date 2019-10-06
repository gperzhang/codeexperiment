package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsgResult pay(String key){
        Payment payment = StrategyManager.getPayment(key);
        System.out.println("欢迎使用"+payment.getName());
        System.out.println("本次交易金额是:"+amount+"开始扣款");
        MsgResult pay = payment.pay(uid, amount);
        return pay;
    }
    public MsgResult pay(){
        return pay(StrategyManager.DEFAULT_PAY);
    }
}
