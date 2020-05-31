package algorithm.multiply.may30;

/**
 * 斐波那契数列 f(n)=f(n-1)+f(n-2),f(1)=f(2)=1
 */
public class Solution {
    public int Fibonacci(int n) {
        if(n==0)return 0;
        if(n<3){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
