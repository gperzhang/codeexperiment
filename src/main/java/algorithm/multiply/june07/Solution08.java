package algorithm.multiply.june07;


public class Solution08 {



    public static void main(String[] args) {
        int [] arr = new int[]{2,4,6,1,3,5,7};
        reOrderArray(arr);

        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void reOrderArray(int [] array) {

        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1;j++){
                if(array[j]%2==0 && array[j+1]%2!=0){
                    swap(array,j,j+1);
                }
            }
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
