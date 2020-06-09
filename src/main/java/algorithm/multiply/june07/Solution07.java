package algorithm.multiply.june07;


import java.util.Arrays;

/**
 * 对于输入的整数数组，使得奇数位于数组的前半端，偶数位于数组的后半端
 * 并且保证奇数和奇数，偶数和偶数之间的相对位置保持不变
 */
public class Solution07 {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7};

        reOrderArray(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
//        Arrays.asList(arr).stream().forEach(a-> System.out.println(a));


        //{1,3,5,7, 2,4,6,8}
    }
    public static  void reOrderArray(int [] array) {
        int i=0,startIndex = 0;
        int j=array.length-1,endIndex = array.length-1;
        while(i<array.length-1 && j>1){
            while(array[i]%2!=0){
                if(i>startIndex){
                    swap(array,i,startIndex++);
                }else {
                    startIndex++;
                }
                break;
            }
            while (array[j]%2==0){
                if(j<endIndex)
                swap(array,j,endIndex--);
                else {
                    endIndex--;
                }
                break;
            }
            i++;
            j--;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
