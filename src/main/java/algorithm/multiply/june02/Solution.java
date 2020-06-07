package algorithm.multiply.june02;

/**
 * 计算二进制表示中1的个数
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(NumberOf1(0));
    }
    public static int NumberOf1(int n) {
        if(n==0)return 0;
        if(n==-1){
            return 32;
        }if(n<-1){
            return 32-NumberOf1(Math.abs(n));
        }
        if(n==1 || n==2)return 1;
        if(n/2==0){
            return NumberOf1(n/2);
        }else {
            return NumberOf1(n/2)+1;
        }
    }
}
