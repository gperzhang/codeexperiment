package pattern.singleton.lazy;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象创建好了以后可能需要序列化存到磁盘，然后在从磁盘中通过反序列化
 * 转化为内存对象，反序列化的对象会进行重新内存分配，相当于重新创建了对象
 */
public class SerializableDestroy {
    public static void main(String[] args) {

        LazySingleton instance = LazySingleton.getInstacne();
        try {
            // 先通过序列化将对象存到磁盘中
            FileOutputStream fos = new FileOutputStream("serialObj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
            oos.flush();
            oos.close();

            //在通过反序列化转换成对象
            FileInputStream fis = new FileInputStream("serialObj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            ois.close();

            System.out.println(o==instance);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
