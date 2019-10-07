package algorithm.program.findmatrix;

/**
 * create by zj 2019-10-07
 */
public class Main {
    public static void main(String[] args) {
        boolean b = find(20, Matrix.metrix);
        System.out.println(b);
    }
    public static boolean find(int target,int[][]des){
        if (des == null || des.length==0 ||des[0].length==0){
            return false;
        }
        int rows = des.length, cols = des[0].length;
        int i=0,j=cols-1;
        while(i<rows-1 && j>=0){
            if (des[i][j]==target){
                return true;
            }else if (target>des[i][j])
                i++;
            else
                j--;
        }

        return false;
    }
}
