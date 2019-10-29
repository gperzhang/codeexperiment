package algorithm.program.duplicatenum;

/**
 * Created by zj on 2019-10-08
 * 数组长度为n,数组内元素的范围为0-n-1，查找第一个重复的数字，要求时间复杂度为O(n)
 */
public class Main {
    int [] arr = {2,3,1,0,2,5};
    public static Integer duplicate(int [] num) throws Exception {
        if (num == null || num.length==0){
            throw new Exception("invalid param");
        }
        for(int i=0;i<num.length;i++){
             while(num[i]!=i){
                 if(num[i]==num[num[i]]){
                     return num[i];
                 }
                swap(num,i,num[i]);
            }
        }
        return null;
    }

    private static void swap(int[] num, int i, int i1) {
        int temp = num[i];
        num[i] = num[i1];
        num[i1] = temp;

    }

    public static void main(String[] args) {

        try {
            Integer duplicate = duplicate(new Main().arr);
            System.out.println(duplicate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
