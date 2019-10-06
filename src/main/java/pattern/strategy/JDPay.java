package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    public double queryBalance(String uid) {
        return 300;
    }
}
