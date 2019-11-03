package algorithm.program.dynamicprogram;

/**
 * Created by zj on 2019-10-30
 */
public class JumpFloor {
    public int jumpFloor(int n) throws Exception {
        if (n<0){
            throw new Exception("参数不正确");
        }if(n<=2){
            return n;
        }
        int result =0;
        int first=1,second=2;
        for(int i=2;i<n;i++){
            result = first+second;
            first =second;
            second = result;
        }
        return result;
    }
}
