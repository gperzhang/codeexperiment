package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order("1", "20191006", 190);
        MsgResult payResult = order.pay(StrategyManager.JD_PAY);
        System.out.println(payResult);
    }
}
