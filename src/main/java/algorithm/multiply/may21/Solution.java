package algorithm.multiply.may21;

public class Solution {

    public static void main(String[] args) {
        String happy = replaceSpace(new StringBuffer("We Are Happy "));
        System.out.println(happy);
    }
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString().replaceAll(" ", "%20");

        return s;
    }
}