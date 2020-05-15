package algorithm.program.dynamicprogram;

/**
 * Created by zj on 2019-11-07
 */
public class CutrRope {
    public int getMaxMulti(int n){

        int [] dp = new int [n+1];
        dp[1] =1;
        dp[2] = 1;
        dp [3] = 3;
        for(int i=4;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],dp[j]*(i-j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int result = new CutrRope().getMaxMulti(8);
        System.out.println(result);
    }
}
