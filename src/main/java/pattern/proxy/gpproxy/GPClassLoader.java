package pattern.proxy.gpproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * create by zj 2019-10-06
 */
public class GPClassLoader extends ClassLoader{
    private String baseDir;

    public GPClassLoader(){
        this.baseDir = GPClassLoader.class.getResource("").getPath();
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName()+"."+name;
        if (baseDir == null)throw new ClassNotFoundException("not found class");
        File  file = new File(baseDir,name+".class");
        if (!file.exists()){
            throw new ClassNotFoundException("class file is not exist");
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte [] buffer = new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            return defineClass(className,bos.toByteArray(),0,bos.size());

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
