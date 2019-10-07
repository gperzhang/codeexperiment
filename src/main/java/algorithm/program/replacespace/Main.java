package algorithm.program.replacespace;

/**
 * create by zj 2019-10-07
 * 把字符串中每一个的空格替换成%20
 */
public class Main {
    public static String replaceSpace(StringBuffer str){
        int p1 = str.length()-1;
        for(int i=0;i<=p1;i++){
            if (str.charAt(i)==' ')
            str.append("  ");
        }
        int p2 = str.length()-1;
        while(p1>=0 && p2>p1){
            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
//        String string = str.toString();
//        String s = string.replaceAll("\\s", "%20");
//        return s;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("A  B");
        String s = replaceSpace(sb);
        System.out.println(s);
    }
}
