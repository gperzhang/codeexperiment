package algorithm.program.doublepointer;

/**
 * Created by zj on 2019-11-01
 */
public class huiwen {

    public boolean validString(String s){
        int length = s.length();
        int begain =0;
        int end = length-1;
        boolean flag = false;
        while(begain<end){
            if (s.charAt(begain) != s.charAt(end)){
                if (flag)
                return false;
                if(s.charAt(++begain)==s.charAt(end) || s.charAt(begain)==s.charAt(--end)){
                    flag = true;
                }
            }
            begain++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new huiwen().validString("abcbfa");
        System.out.println(result);
    }
}
