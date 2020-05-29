package algorithm.multiply.may29;

/**
 * 非递减排序？
 */
public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{3,4,5,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0)return 0;
        int i=0;
        while(i<array.length-1 && array[i]<=array[i+1]){
            i++;
        }
        return array[i+1];
    }
}
