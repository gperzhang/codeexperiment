package pattern.prototype.deep;

import java.io.*;
import java.util.Date;

public class QiTianDaSheng extends Monkey implements Cloneable,Serializable {
    public JinGuBang jinGuBang;

    public QiTianDaSheng(){
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }
    @Override
    public Object clone(){
        try {
            return this.deepClone();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Object deepClone() throws IOException {
        QiTianDaSheng  copy = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            copy = (QiTianDaSheng) ois.readObject();
            copy.birthday = new Date();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return copy;
    }

    public Object shallowClone(QiTianDaSheng target){
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.birthday = target.birthday;
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.weight;
        qiTianDaSheng.jinGuBang = target.jinGuBang;
        qiTianDaSheng.birthday = target.birthday;

        return qiTianDaSheng;

    }
}
