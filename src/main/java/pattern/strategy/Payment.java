package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public abstract class Payment {
    public abstract String getName();

    public abstract double queryBalance(String uid);

    public MsgResult pay(String uid,double amount){
        if (queryBalance(uid)<amount){
            return new MsgResult(501,"支付失败","余额不足");
        }
        return new MsgResult(200,"支付成功","支付金额"+amount);
    }
}
