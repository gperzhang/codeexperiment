package algorithm.program.sort;

/**
 * Created by zj on 2019-11-04
 * 时间复杂度O(N*N)是不稳定的排序算法，移动的次数最多为(n-1)n/2
 */
public class PaopaoSort {
    public void sort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {5,9,7,3,1,2,8};
        new PaopaoSort().sort(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
