package base.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedHashMap是插入有序的，默认不开启访问顺序，当开启访问顺序之后，会把最近访问的放到链表的最后
 * @author zj
 * @date 2019-09-18 17:58
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String, String>(16,0.75F,true);

        System.out.println("key".hashCode());
        for (int i=0;i<10;i++){
            hashMap.put("key"+i,"value"+i);
            linkedHashMap.put("key"+i,"value"+i);
        }
        linkedHashMap.get("key"+3);
        System.out.println("hashmap 遍历");
        for (Map.Entry value: hashMap.entrySet()) {
            System.out.print(value.getValue()+",");
        }

        System.out.println("linkedhashmap 遍历");
        for (Map.Entry v:linkedHashMap.entrySet()){
            System.out.print(v.getValue()+"---");
        }
    }
}
