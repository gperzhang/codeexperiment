package algorithm.multiply.june01;

/**
 * 变态跳台阶，一只青蛙一次可以跳一阶也可以跳n阶，跳n阶台阶有多少种跳法
 */
public class Solution {
    public int JumpFloorII(int target) {
        if(target==0)return 0;
        if(target==1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}
