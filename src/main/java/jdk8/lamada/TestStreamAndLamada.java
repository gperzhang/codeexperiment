package jdk8.lamada;

import java.util.ArrayList;
import java.util.List;

public class TestStreamAndLamada {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("zhangjie");
        list.add("xiaoli");
        list.add("xiaowang");
        list.add("zhangjie");


        long mount = list.stream().filter(s -> s.equals("zhangjie")).count();
        System.out.println(mount);
    }
}
