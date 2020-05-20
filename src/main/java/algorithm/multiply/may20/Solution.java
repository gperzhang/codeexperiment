package algorithm.multiply.may20;

public class Solution {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        boolean find = Find(1, arr);
        System.out.println(find);
    }
    public static boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=array[i].length-1;j>=0;j--){
                if(target==array[i][j])
                    return true;
                if(target>array[i][j])
                    break;
                if(target<array[i][j])
                    continue;
            }
        }
        return false;
    }
}