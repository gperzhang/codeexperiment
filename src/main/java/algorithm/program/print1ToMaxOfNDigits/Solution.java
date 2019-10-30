package algorithm.program.print1ToMaxOfNDigits;

public class Solution {
    public void print1ToMaxOfNDigits(int n){
        if (n<=0){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(9);
        }
        Integer integer = Integer.valueOf(sb.toString());
        for(int i=1;i<=integer;i++){
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        new Solution().print1ToMaxOfNDigits(4);
    }
}
