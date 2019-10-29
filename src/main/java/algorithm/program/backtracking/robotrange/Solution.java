package algorithm.program.backtracking.robotrange;

/**
 * Created by zj on 2019-10-29
 */
public class Solution {

    int count = 0;
    private int isRightMove(int rows,int cols,int threshold) {

        boolean [][] marked = new boolean[rows][cols];
        dfs(marked,rows,cols,0,0,threshold);
        return count;
    }

    private void dfs(boolean[][] marked,int rows,int cols, int r, int c,int threshold) {
        if (r<0 || r>=rows || c<0 || c>=cols || marked[r][c])return;
        marked[r][c]=true;
        if(digitalSum(r,c)>threshold){
            return;
        }
        count++;
        dfs(marked,rows,cols,r-1,c,threshold);
        dfs(marked,rows,cols,r+1,c,threshold);
        dfs(marked,rows,cols,r,c-1,threshold);
        dfs(marked,rows,cols,r,c+1,threshold);
    }

    private int digitalSum(int r, int c) {
        int sumRows =0,sumCols =0;
        while(r>0){
            sumRows+=r%10;
            r/=10;
        }
        while(c>0){
            sumRows+=c%10;
            c/=10;
        }
        return sumCols+sumRows;
    }

    public static void main(String[] args) {
        new Solution().isRightMove(20,20,15);
    }
}
