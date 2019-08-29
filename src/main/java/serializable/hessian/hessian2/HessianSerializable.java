package serializable.hessian.hessian2;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import serializable.hessian.People;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HessianSerializable {

    public void serializable(Object obj){
        FileOutputStream fos = null;
        Hessian2Output hessianOutput = null;
        ByteArrayOutputStream bos = null;
        try {
            fos = new FileOutputStream("D:/2.txt");
            hessianOutput = new Hessian2Output(fos);
            hessianOutput.writeObject(obj);
            //这三步是什么意思？？ 必须要flush才能成功写？
            hessianOutput.getBytesOutputStream().flush();
            hessianOutput.completeMessage();
            hessianOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            if(fos !=null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public Object deserializable(){
        FileInputStream fis = null;
        try {
           fis = new FileInputStream("D:/2.txt");
           Hessian2Input hessianInput = new Hessian2Input(fis);
           System.out.println("hessain序列化后文件大小"+fis.available());
           return hessianInput.readObject();
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

    public static void main(String[] args) {
        HessianSerializable hessianSerializable = new HessianSerializable();
//        People people = new People();
//        people.setNumber("123");
//        people.setAddress("anhui");
//        people.setName("zhangjie");
//        hessianSerializable.serializable(people);
        Object deserializable = hessianSerializable.deserializable();
        People people = (People) deserializable;
        System.out.println(people.getAddress()+">>>"+people.getName()+">>>>"+people.getNumber());
    }
}
