package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 100;
    }
}
