package pattern.prototype.clone;

/**
 * Created by zj on 2020-05-14
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setName("zhangjie");
        user.setAge(18);
        Address address = new Address();

        user.setAddress(address);
        address.setProvince("anhui");
        address.setCity("tongling");
        address.setArea("zongyang");

        User user1 = (User) user.clone();
        user1.address = (Address) address.clone();
        System.out.println(user==user1);
        System.out.println(user.getAddress()==user1.getAddress());
        System.out.println(user.getAddress().toString());
        System.out.println(user1.getAddress().toString());
    }
}
