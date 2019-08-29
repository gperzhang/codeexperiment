package serializable.java;
public class Test {
    public static void main(String[] args) {
        Operate operate = new Operate();
//        People people = new People();
//        people.setNumber("123");
//        people.setAddress("anhui");
//        people.setName("zhangjie");
//        //将对象序列化到磁盘上存储
//        operate.doSerializable(people);


        // 反序列化操作
        Object o = operate.unSerializable();
        People people = (People) o;
        System.out.println(people.getAddress()+"..."+people.getName()+"..."+people.getNumber());

    }
}
