package algorithm.program.sort;

/**
 * Created by zj on 2019-11-04
 * 堆排序利用完全二叉树的特点，左子树的位置=2*root+1，右子树的位置=2*root+2;
 * 除了最后一层外的其他每一层都被填充，完全二叉树又分为大顶堆和小顶堆
 *
 * 1、将数组中的位置构建为大堆
 * 2、将堆顶与最后一个节点交换，再讲剩下的n-1长度的数组构建为大堆
 * 3、最后得出的数组即为排序完成的结果，遍历输出即可
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {5,9,7,3,1,2,8};

        new HeapSort().heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public void heapSort(int [] arr){
        int len = arr.length;
        buildMaxHeap(arr,len);

        for(int i=len-1;i>0;i--){
            swap(arr,0,i);
            len--;
            heapRebuild(arr,len,0);
        }

    }

    private void buildMaxHeap(int[] arr, int len) {
        int root = len/2;
        for(int i=root;i>=0;i--){
            heapRebuild(arr,len,i);
        }
    }

    private void heapRebuild(int[] arr, int len, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left<len && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<len && arr[right]>arr[largest]){
            largest = right;
        }if(largest !=i){
            swap(arr,i,largest);
        }
    }

    private void swap(int[] arr, int left, int largest) {
        int temp = arr[left];
        arr[left] = arr[largest];
        arr[largest] = temp;
    }
}
