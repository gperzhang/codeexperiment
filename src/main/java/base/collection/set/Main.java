package base.collection.set;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zj
 * @date 2019-09-18 14:31
 */
public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        set1.add("11");
        TreeSet<String> set2 = new TreeSet<>();
        set2.add("12212");

        Vector<String> vector = new Vector<>();
        List<String> arraylist = new ArrayList<>();
        List<String> linkedlist = new LinkedList<>();
        Stack stack = new Stack();

        Map<String,String> map = new HashMap<>();
        Map<String,String> map1 = new LinkedHashMap<>();
        Map<String,String> map2 = new TreeMap<>();
        Map<String,String> map3 = new ConcurrentHashMap<>();

        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
    }
}
