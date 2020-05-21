package algorithm.multiply.may20;

/**
 * Created by zj on 2020-05-21
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        long start = System.currentTimeMillis();
        boolean find = Find(9, arr);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(find);

    }
    public static boolean Find(int target, int [][] array){

        int m=array.length,n=array[0].length-1;
        int i=0,j=n;
        while (i<m && j>=0){
            if(array[i][j]==target){
                return true;
            }else if(array[i][j]>target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
