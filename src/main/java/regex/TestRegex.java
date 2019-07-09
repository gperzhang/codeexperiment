package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        //        String s1 = "D:/install path/Everything";
//        String s2 = "D:\\install path\\Everything";
//        String s3 = "com.ecarx.util.SpringContextHolder";
//        String s4 = "C:\\install.log";
//        System.out.println(s1.replace("/","a"));
//        System.out.println(s3.replaceAll("\\.","-"));
//        System.out.println(s2.replaceAll("\\\\","\\."));
//        File file = new File(s4);
//        System.out.println(file.exists());
        String regx = "-?\\d+(\\.\\d+)?";
        String dateRegx = "[1-9]\\d{0,3}-(1[0-2]|0?[1-9])-(3[01]|[12]?\\d|0?[1-9])";
        String reg = "\\w{8,10}";
        String s = "2019_09_08";
        
        String x = "1-2*((60-30+(-40/5)*(9-2*5/3+7/3*99/4*2998+10*568/14))-(-4*3)/(16-3*2))";
        String regx1 = "\\([^()]+\\)";

        String data = "9-2*5/3+7/3*99/4*2998+10*568/14";
        String regxdata = "\\d+[*/]\\d";

        String regx2 = "([^\\[<]+?)";
        String regx22 = "[^<]+";
        String regex33 = "([^\\[\"']+?)";
        String s2 = "1234";
        System.out.println(s2.matches(regex33));

        String x1 = "abc1234";
        String sregx = "\\d+";
        Pattern pattern = Pattern.compile(regx1);
        Matcher matcher = pattern.matcher(x);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }

    }

}

