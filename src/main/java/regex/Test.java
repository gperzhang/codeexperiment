package regex;

public class Test {
    public static void main(String[] args) {
        // \\s 匹配任意空白符
        String match = "\\s*[,]+\\s*";
        String match1 = ",*[|]+\\s*";
        String s= "com,gupao,,edu,,  regex";
        String s1 = "hdu,,|edu|||cn";
        String[] split = s1.split(match1);
        System.out.println(split.length);
        for (String str:split) {
            System.out.println(str);

        }
    }
}
