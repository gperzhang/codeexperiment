package serializable.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HessianSerializable {

    public void serializable(Object obj){
        FileOutputStream fos = null;
        HessianOutput hessianOutput = null;

        try {
            fos = new FileOutputStream("D:/c.txt");
            hessianOutput = new HessianOutput(fos);
            hessianOutput.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos !=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object deserializable(){
        FileInputStream fis = null;
        try {
           fis = new FileInputStream("D:/c.txt");
           HessianInput hessianInput = new HessianInput(fis);
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
