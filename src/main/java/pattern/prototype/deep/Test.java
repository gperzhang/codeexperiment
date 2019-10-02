package pattern.prototype.deep;

public class Test {
    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        QiTianDaSheng qiTian = (QiTianDaSheng) qiTianDaSheng.clone();
        System.out.println("深克隆:"+(qiTian.jinGuBang == qiTianDaSheng.jinGuBang));

        QiTianDaSheng shallowClone = (QiTianDaSheng) qiTianDaSheng.shallowClone(qiTianDaSheng);
        System.out.println("浅克隆:"+(qiTianDaSheng.jinGuBang == shallowClone.jinGuBang));
    }
}
