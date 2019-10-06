package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class WeChatPay extends Payment{
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public double queryBalance(String uid) {
        return 500;
    }
}
