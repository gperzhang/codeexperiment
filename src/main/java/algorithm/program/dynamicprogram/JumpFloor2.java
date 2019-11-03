package algorithm.program.dynamicprogram;

import java.util.Arrays;

/**
 * Created by zj on 2019-10-30
 */
public class JumpFloor2 {


    public int jumpFloor2(int n){
        int [] dp = new int[n];

        //边界值怎么找
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int i = new JumpFloor2().jumpFloor2(3);
        System.out.println(i);
    }
}
