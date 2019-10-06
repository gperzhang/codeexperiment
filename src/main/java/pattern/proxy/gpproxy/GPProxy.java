package pattern.proxy.gpproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author zj
 * @date 2019-10-06
 */
public class GPProxy{

    private static final String ln = "\r\n";
    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws Exception
    {
        //1.生成代理类的源码
        String source = genSource(interfaces);
        System.out.println(source);
        //2.将生成的源码输出到磁盘，保存为.java文件
        String path = GPProxy.class.getResource("").getPath();
        File file = new File(path + "$Proxy0.java");
        FileWriter fw = new FileWriter(file);
        fw.write(source);
        fw.flush();
        fw.close();
        //3.编译源代码，并生成.java文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null,manager,null,null,null,iterable);
        task.call();
        manager.close();
        //4.将class 文件中的内容 动态加载到jvm中
        Class<?> proxyClass = loader.findClass("$Proxy0");
        //5.返回被代理后的代理对象
        Constructor<?> constructor = proxyClass.getConstructor(GPInvocationHandler.class);

        return constructor.newInstance(h);
    }

    private static String genSource(Class<?>[] interfaces) {
        StringBuilder src = new StringBuilder();
        src.append("package pattern.proxy.gpproxy;").append(ln)
                .append("import java.lang.reflect.Method;").append(ln)
                .append("public class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(ln)
                    .append("private GPInvocationHandler h;").append(ln)
                    .append("public $Proxy0(GPInvocationHandler h)").append("{").append(ln)
                    .append("this.h = h;").append(ln)
                    .append("}").append(ln);

                for(Method method:interfaces[0].getMethods()){
                    src.append("public ").append(method.getReturnType()+" ").append(method.getName()).append("(){").append(ln)
                            .append("try{").append(ln)
                            .append("Method m =").append(interfaces[0].getName()).append(".class.getMethod(\"").append(method.getName()).append("\");").append(ln)
                            .append("this.h.invoke(this,m,new Object[]{});").append(ln)
                            .append("}").append("catch(Throwable e){").append(ln)
                            .append("e.printStackTrace();").append(ln)
                            .append("}").append(ln);
                }
        src.append("}").append(ln).append("}");
        return src.toString();
    }

}
