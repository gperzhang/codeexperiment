package jdk8.lamada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestStreamAndLamada {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangjie");
        list.add("xiaoli");
        list.add("xiaowang");
        list.add("zhangjie");

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap();
        HashMap<String,String> hashMap = new HashMap<>();

        hashMap.put("1","2");
        map.put("123","456");

        long mount = list.stream().filter(s -> s.equals("zhangjie")).count();
        System.out.println(list.stream().map(s -> s+"111").collect(Collectors.toList()));
        System.out.println(mount);
        System.out.println(Integer.numberOfLeadingZeros(16) );
    }
}
