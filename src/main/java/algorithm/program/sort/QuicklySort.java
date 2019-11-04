package algorithm.program.sort;

/**
 * Created by zj on 2019-11-04
 * 快速排序是对冒泡的一种改进
 * 第一趟，先将第一个数作为基准，大于他的都放到右边，小于的都放到左边
 * 然后将两边的子序列再次这样递归
 */
public class QuicklySort {

    public void quicklySort(int [] arr,int begin ,int end){
        int i = begin,j = end;
        int sta = arr[i];
        while(i<j){
            while(i<j && arr[j]>sta){
                j--;
            }
            while (i<j && arr[i]<sta){
                i++;
            }if(i<j && arr[i]==arr[j]){
                i++;
            }else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if(i-1>begin)quicklySort(arr,begin,i-1);
        if(end>j+1)quicklySort(arr,j+1,end);
    }
    public static void main(String[] args) {
        int [] arr = {5,9,7,3,1,2,8,5};
        new QuicklySort().quicklySort(arr,0,7);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
