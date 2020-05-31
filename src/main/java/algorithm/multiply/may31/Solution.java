package algorithm.multiply.may31;

/**
 * 青蛙跳台阶问题，一只青蛙一次可以跳一个台阶，也可以跳两个台阶，一共有多少种跳法
 */
public class Solution {

    public int JumpFloor(int target) {
        if(target<3)return target;

        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
