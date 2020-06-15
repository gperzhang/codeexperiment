package algorithm.multiply.june15;

/**
 * 二叉树的后序遍历
 */
public class Solution {

    public static void main(String[] args) {
        int arr[] = new int[]{4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(arr));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence==null || sequence.length==0)return false;
        return verifyBST(sequence,0,sequence.length-1);
    }

    private static boolean verifyBST(int[] sequence, int start, int end) {
        int root = sequence[end];
        int i=0;
        for(i=start;i<end;i++){
            if(sequence[i]>root)
            break;
        }
        for(int j=i;j<end;j++){
            if(sequence[j]<root)
                return false;
        }
        return verifyBST(sequence,start,i-1) && verifyBST(sequence,i,end-1);
    }
}
