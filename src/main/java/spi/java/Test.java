package spi.java;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<IService> load = ServiceLoader.load(IService.class);
        Iterator<IService> iterator = load.iterator();
        while (iterator.hasNext()){
            IService next = iterator.next();
            System.out.println(next.sayHello()+"..."+next.getScheme());
        }
    }
}
