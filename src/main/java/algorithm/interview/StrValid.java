package algorithm.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrValid {
    public static void main(String[] args) {
        boolean valid = valid("apple", "a2e");
        System.out.println(valid);
    }

    public static boolean valid(String word,String abbr){
        Pattern compile = Pattern.compile("\\d+");
        Matcher matcher = compile.matcher(abbr);
        int wordIndex =0,abbrIndex=0,count=0;
        boolean flag =false;
        if(matcher.matches() && word.length()==Integer.parseInt(abbr)){
            return true;
        }
        for(int i=0;i<abbr.length() && wordIndex<word.length() && abbrIndex<abbr.length();i=i+count){
            count=0;
            StringBuilder sb = new StringBuilder();
            while(abbrIndex<abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))){
                sb.append(abbr.charAt(abbrIndex));
                abbrIndex++;
                count++;
            }
            if(count==0)count=1;
            if(!sb.toString().isEmpty()){
                wordIndex+=Integer.parseInt(sb.toString());
            } else if(word.charAt(wordIndex++) != abbr.charAt(abbrIndex++)){
                return flag;
            }
            if((wordIndex==word.length()) && (abbrIndex==abbr.length())){
                flag = true;
            }
        }
        return flag;
    }
}
