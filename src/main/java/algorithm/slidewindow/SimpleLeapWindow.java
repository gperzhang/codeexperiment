package algorithm.slidewindow;

public class SimpleLeapWindow {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,5,4,8};
        calByLeadWindow(arr,3);
    }

    public static void calByLeadWindow(int [] arr,int k){
        if(k>arr.length){
            System.out.println("invalid params");
        }
        int maxSum = 0;
        for(int i=0;i<k;i++){
            maxSum+=arr[i];
        }
        int currentWin = maxSum;
        for(int j=k;j<arr.length;j++){
            currentWin+=arr[j]-arr[j-k];
            if(currentWin>maxSum){
                maxSum = currentWin;
            }
        }
        System.out.println("maxSum:"+maxSum);
    }
}
