package algorithm.program.doublepointer;

/**
 * Created by zj on 2019-11-01
 */
public class TwoSum {
    public int [] getTwoSum(int []arr,int target){
        int begain = 0;
        int end = arr.length-1;
        while(begain<end){
            if (arr[begain]+arr[end]==target){
                return new int[]{begain,end};
            }
            else if (arr[begain]+arr[end]>target){
                if(arr[begain]>arr[end]){
                    begain++;
                }else {
                    end--;
                }

            }else {
                if(arr[begain]>arr[end]){
                    end++;
                }else {
                    begain--;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] array = new int[]{15,11,7,2};
        int[] twoSum = new TwoSum().getTwoSum(array, 9);
        for (int a:twoSum){
            System.out.println(a);
        }

    }
}
