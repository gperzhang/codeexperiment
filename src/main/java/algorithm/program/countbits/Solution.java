package algorithm.program.countbits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> countBits(int num){
        int count =0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=num;i++){
            int result = count2(i);
            list.add(result);
        }
        return list;
    }

    private int count2(int i) {
        if(i<2){
            return i;
        }if(i%2==0){
            return count2(i/2);
        }else {
            return count2(i-1)+1;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().countBits(5);
        list.stream().forEach(val-> System.out.println(val));
    }
}
