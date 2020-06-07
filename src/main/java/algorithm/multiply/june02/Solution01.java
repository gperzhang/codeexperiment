package algorithm.multiply.june02;

public class Solution01 {

    public static int NumberOf1(int n) {
        int count =0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
