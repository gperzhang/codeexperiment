package classload.defineclassloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class DiskClassLoader extends ClassLoader {

    private String path;
    public DiskClassLoader(String path){
        this.path=path;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(path,fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte [] b = new byte[1024];
            int len =0;
            while((len=fis.read(b))!=-1){
                bos.write(b,0,len);
            }
            byte[] data = bos.toByteArray();
            fis.close();
            bos.close();
            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public String getFileName(String name){
        //"classload.defineclassloader.SayTest"
        int index = name.lastIndexOf(".");
        if (index == -1){
            return name+".class";
        }else {
            return name.substring(index+1)+".class";
        }
    }
}
