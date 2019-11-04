package algorithm.program.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zj on 2019-11-01
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        for (int i=0;i<list.size();i++){
            if(list.get(i)==22);
            Integer remove = list.remove(i);
            System.out.println(remove);
        }
    }
}
