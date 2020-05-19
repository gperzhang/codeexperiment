package algorithm.interview;

import java.util.Arrays;

/**
 * Created by zj on 2020-05-19
 */
public class MergeArray {
    public static void main(String[] args) {
//        int[][]arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][]arr = {{1,4},{4,5}};
        int[][] merge = merge(arr);

        for (int[] ints : merge) {
            System.out.println(ints[0]+","+ints[1]);
        }

    }

    public static int [][] merge(int[][]intervals){
        int [][] arr = new int[intervals.length][2];
        int start = 0,end=0;
        int count =0;
        for (int i=0;i<intervals.length;i=end+1){
            end=start=i;
            while(i<intervals.length-1 && intervals[i][1]>=intervals[i+1][0]){
                end = i+1;
                i++;
            }
            arr[count]= new int[]{intervals[start][0], intervals[end][1]};
            count++;
        }
        int[][] ints = Arrays.copyOf(arr, count);
        return ints;
    }
}
