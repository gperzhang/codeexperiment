package serializable.java;

import java.io.*;

public class Operate {

    //序列化一个对象,把内存中的对象写到磁盘中
   public void doSerializable(Object obj){
       FileOutputStream fos =null;
       try {
           fos = new FileOutputStream("D:/b.txt");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(obj);
       } catch (IOException e) {
           e.printStackTrace();
       }finally {
           if(fos!=null) {
               try {
                   fos.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   //反序列化，把磁盘中的对象读成内存中的一个对象形式
   //所以说，磁盘中所存储的对象全都是以字节编码的形式存在的吗？
   public Object unSerializable(){
       FileInputStream fis = null;
       try {

           fis = new FileInputStream("D:/b.txt");
           ObjectInputStream ois = new ObjectInputStream(fis);
           System.out.println("序列化存在磁盘文件中对象的大小："+fis.available()+"字节");

           Object object = ois.readObject();
           return object;
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           if(fis != null){
               try {
                   fis.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       return null;
   }

}
