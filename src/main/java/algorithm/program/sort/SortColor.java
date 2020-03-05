package algorithm.program.sort;

/**
 * Created by zj on 2019-11-05
 * 只用一次迭代完成排序
 * [1,1,2,0,2,0]
 *
 * [0,0,1,1,2,2]
 */
public class SortColor {

    public void sortColor(int [] arr){
        int before = 0,behind = arr.length-1,current = 0;
        while(current<behind){
            if(arr[current]==2){
                swap(arr,current,behind--);
            }if(arr[current]==0){
                swap(arr,before++,current++);
            }else {
                current++;
            }
        }
    }
    public void swap(int [] arr ,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {2,0,2,1,1,0};
        new SortColor().sortColor(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }
}
