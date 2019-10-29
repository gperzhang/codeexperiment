package algorithm.program.backtracking.strmatrix;

/**
 * Created by zj on 2019-10-29
 * 要从一个矩阵中找出一个字符串的路径是否存在
 * 1.首先要找到一个起始点的位置
 * 2.通过一个数组记录当前路径是否被走过
 * 3.再找下一个节点，找失败时回退
 */
public class Solution {

    public boolean hasPath(char [] matrix,int rows,int cols,char[] str){
        if (rows<0 || cols<0 || matrix.length<=0 || str.length<0){
            return false;
        }
        boolean [] visited = new boolean[rows*cols];
        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isPath(matrix,rows,cols,i,j,visited,count,str))
                    return true;
            }
        }

        return false;
    }

    private boolean isPath(char[] matrix, int rows, int cols, int i, int j, boolean[] visited, int count,char [] str) {
        if(count==str.length){
            return true;
        }
        boolean flag = false;
        if (i>=0 && i<rows && j>=0 && j<cols && !visited[i*cols+j] && matrix[i*cols+j]==str[count]){
            count++;
            visited[i*cols+j]=true;
            flag = isPath(matrix,rows,cols,i-1,j,visited,count,str)
                    || isPath(matrix,rows,cols,i+1,j,visited,count,str)
                    || isPath(matrix,rows,cols,i,j-1,visited,count,str)
                    || isPath(matrix,rows,cols,i,j+1,visited,count,str);
            if(!flag){
                count--;
                visited[i*cols+j]=false;
            }

        }
        return flag;
    }

    public static void main(String[] args) {
        String str = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        char[] matrix = str.toCharArray();
        String str2 = "ASFD";
        char[] c = str2.toCharArray();
        System.out.println(new Solution().hasPath(matrix, 5, 8, c));

    }

}
