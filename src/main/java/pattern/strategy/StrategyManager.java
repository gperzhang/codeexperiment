package pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * create by zj 2019-10-06
 */
public class StrategyManager {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JDPay";
    public static final String WECHAT_PAY = "WeChatPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> paymentMap = new HashMap<>();

    static
    {
        paymentMap.put("AliPay",new AliPay());
        paymentMap.put("JDPay",new JDPay());
        paymentMap.put("WeChatPay",new WeChatPay());
        paymentMap.put("UnionPay",new UnionPay());
    }
    public static Payment getPayment(String key){
        if (!paymentMap.containsKey(key)){
            return paymentMap.get(DEFAULT_PAY);
        }return paymentMap.get(key);
    }
}
