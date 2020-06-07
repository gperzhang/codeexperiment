package algorithm.multiply.june07;

import java.util.ArrayList;
import java.util.List;

public class Solution08 {
    public void reOrderArray(int [] array) {
        List<Integer> listOdd = new ArrayList<>();
        List<Integer> listDou = new ArrayList<>();

        for (int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                listOdd.add(array[i]);
            }else {
                listDou.add(array[i]);
            }
        }

    }
}
