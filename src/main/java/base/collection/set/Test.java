package base.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;

/** linkedHashSet 插入有序
 * 插入顺序？
 * 访问顺序？
 * @author zj
 * @date 2019-09-18 16:57
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        HashSet<String> hashSet = new HashSet<>();
        for (int i=0;i<10;i++){
            linkedHashSet.add("I-"+i);
            hashSet.add("I-"+i);
        }
        System.out.println("linkedHashSet的遍历：");

        for (String s:linkedHashSet){
            System.out.println(s);
        }

        System.out.println("hashSet的遍历：");
        for (String s:hashSet){
            System.out.print(s);
        }
    }
}
