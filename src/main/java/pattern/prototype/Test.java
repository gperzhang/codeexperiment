package pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA();
        prototypeA.setName("zhangjie");
        prototypeA.setAge("17");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("study");
        prototypeA.setHobbies(hobbies);

        Client client = new Client(prototypeA);
        ConcretePrototypeA prototypeClone = (ConcretePrototypeA) client.startClone();


        System.out.println(prototypeA==prototypeClone);
        System.out.println("原对象中bobbies地址:"+prototypeA.getHobbies());
        System.out.println("克隆对象中的地址"+prototypeClone.getHobbies());
    }
}
