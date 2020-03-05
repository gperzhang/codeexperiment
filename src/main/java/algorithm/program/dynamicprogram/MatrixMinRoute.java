package algorithm.program.dynamicprogram;

/**
 * Created by zj on 2019-11-05
 */
public class MatrixMinRoute {
    public static void main(String[] args) {
      int [][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = new MatrixMinRoute().minPathSum(arr);
        System.out.println(i);
    }
    public int minPathSum(int [][] matrix){
        if (matrix.length==0 || matrix[0].length==0)return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int [][] dp = new int[height][width];

        for(int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if(j==0 && i==0){
                    dp[i][j] = matrix[i][j];
                }else if(j==0 && i>0){
                    dp[i][j] = dp[i-1][j]+matrix[i][j];
                }else if(i==0 && j>0){
                    dp[i][j] = dp[i][j-1]+matrix[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
                }
            }
        }
        return dp[height-1][width-1];
    }
}
