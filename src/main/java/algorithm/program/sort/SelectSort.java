package algorithm.program.sort;

/**
 * Created by zj on 2019-11-04
 * 每排序一趟记录最大或者最小下标位置，只做一次移动
 */
public class SelectSort {

    public void selectSort(int [] arr){

        for(int i=0;i<arr.length-1;i++){
            //每一趟比较都先默认第一个值为最小
            int index = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,9,7,3,1,2,8};
        new SelectSort().selectSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
