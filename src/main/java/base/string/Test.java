package base.string;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
       String [] strings = {"1","2","3","4","5"};
        String s = Arrays.toString(strings);
        System.out.println(s);
        String s1 = s.replaceAll("\\[|\\]","");
        System.out.println(s1);
        System.out.println(s1.replaceAll("\\s",","));

    }
}
