package base.string;


/**
 * Created by zj on 2019-10-08
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] anInt = new ArrayTest().getInt();
        for(int i=0;i<anInt.length;i++){
            System.out.println(anInt[i]);
        }

    }

    private int [] getInt(){
        final int [] arr = {1,2,3};
        arr[0] = 12;
        return arr;
    }
}
