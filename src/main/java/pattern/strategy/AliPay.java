package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public double queryBalance(String uid) {
        return 1000;
    }
}
