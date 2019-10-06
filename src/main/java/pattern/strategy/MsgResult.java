package pattern.strategy;

/**
 * create by zj 2019-10-06
 */
public class MsgResult {
    private int code;
    private String msg;
    private Object data;

    public MsgResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "MsgResult:" +
                "支付状态:["+ code + "],"+ msg+",交易详情="+ data;
    }
}
