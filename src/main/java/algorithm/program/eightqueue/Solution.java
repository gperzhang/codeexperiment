package algorithm.program.eightqueue;

/**
 * Created by zj on 2019-10-28
 */
public class Solution {
    public static int [][] array = new int[8][8];

    private static int count = 0;

    public static void  findQueue(int row){
        if (row>7){
            count++;
            return;
        }

        for(int column=0;column<8;column++){
            if (check(row,column)){
                array[row][column]=1;
                findQueue(row+1);
                array[row][column]=0;
            }
        }

    }

    private static boolean check(int row, int column) {
        //行列
        for(int i=0;i<8;i++){
            if (array[i][column]==1){
                return false;
            }
        }
        //左斜线
        for(int i=row-1,k=column+1; i>=0 && k<=7 ;i--,k++){
            if (array[i][k]==1){
                return false;
            }
        }
        //右斜线
        for(int i=row-1,k=column-1;i>=0 && k>=0;i--,k--){
            if(array[i][k]==1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        findQueue(0);
        System.out.println(count);
    }


}
