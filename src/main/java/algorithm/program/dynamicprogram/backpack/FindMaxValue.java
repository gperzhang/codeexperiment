package algorithm.program.dynamicprogram.backpack;

/**
 * Created by zj on 2019-11-05
 * W 背包总承重
 * N 物品数量
 * weight = [2,3,4,5]
 * values = [3,4,5,6]
 */
public class FindMaxValue {
    public int findMaxValue(int W,int N,int [] weigths,int [] value){
        int [][] dp = new int[N+1][W+1];
        for(int i=1;i<=N;i++){
            int w = weigths[i],v = value[i];
            for(int j=0;j<W;j++){
                if (j>=w){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
