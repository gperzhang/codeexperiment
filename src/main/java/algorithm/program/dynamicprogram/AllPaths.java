package algorithm.program.dynamicprogram;

/**
 * Created by zj on 2019-11-05
 */
public class AllPaths {
    public int getAllPaths(int m,int n){
        int [][] dp =new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j] =1;
                }else {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

    }
}
