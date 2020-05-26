package algorithm.multiply.may21;

public class Solution1 {
    public static String replaceSpace(StringBuffer str) {

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                 str.append("  ");
            }
        }
        return null;
    }
}
