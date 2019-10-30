package algorithm.program.reactcover;

public class Solution {
    public int  reactCover(int n){
        if (n==1){
            return 1;
        }else {
            return  reactCover(n-1)+reactCover(n-2);
        }
    }
}
