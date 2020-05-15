package base.string;

import java.util.Arrays;

/**
 * Created by zj on 2019-10-09
 */
public class MeString {

    private char [] value;

    public MeString(){
        this.value = new char[16];
    }

    public int getCount(){
        return value.length;
    }
    public MeString append(String str){
        int cap = getCount()*2+2;
         this.value = Arrays.copyOf(value, cap);
         return this;
    }
}
