package pattern.singleton.register;

import java.io.*;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = null;

        EnumSingleton enumSingleton2 = EnumSingleton.getInstance();
        enumSingleton2.setData(new Object());
        try {
            FileOutputStream fileOutputStream =new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(enumSingleton2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            enumSingleton  = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println(enumSingleton.getData()==enumSingleton2.getData());
            System.out.println(enumSingleton.getData());
            System.out.println(enumSingleton2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
