package pattern.delegate;

/**
 * create by zj 2019-10-06
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss(new Manager());
        boss.command("搭建架构");
        boss.command("实现业务");
    }
}
