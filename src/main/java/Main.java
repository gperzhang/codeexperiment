import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author acai
 * @Date 2021/7/23
 */
public class Main {

    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issipi";
//        System.out.println(strStr(s1,s2));

        find("abab");

        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Queue<Integer> queue = new LinkedBlockingDeque<>();


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        result.add(res);


        Map<Integer,Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }







        Deque<Integer> queue1 = new LinkedBlockingDeque<>();
        Deque<Integer> queue2 = new LinkedBlockingDeque<>();
        if (s1.charAt(1) == stack1.peek())
        queue1.addFirst(1);
        queue1.addFirst(2);
        queue1.removeFirst();
        queue1.removeLast();

        StringBuilder stringBuilder = new StringBuilder();

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (tokens[i] == "+")stack.push(num1+num2);
                if (tokens[i] == "-")stack.push(num1-num2);
                if (tokens[i] == "*")stack.push(num1*num2);
                if (tokens[i] == "/")stack.push(num1/num2);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static boolean find(String s){
        int len = s.length();
        int [] next = new int[len];
        getNext(next,s);

        if (next[len -1] != 0 && (len %(len - next[len-1])) == 0){
            return true;
        }
        return false;
    }



    public static int strStr(String haystack, String needle) {
        if(needle.equals("")){return 0;}
        if (needle.length()>haystack.length()){return -1;}

        int [] next = new int[needle.length()];
        getNext(next,needle);
        int j = 0;
        for(int i=0;i<haystack.length();i++){

            while(j>0 && haystack.charAt(i) != needle.charAt(j)){
                j=next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;

    }

    public static void getNext(int []next, String str){
        int j = 0;
        next[0] = 0;
        for(int i=1;i<str.length();i++){
            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = next[j-1];
            }
            if (str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    public String reverse(String s, int k){
        if (s.length() == 1){return s;}
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i=(i+2*k)){
            StringBuilder tmp = new StringBuilder();
            tmp.append(s.charAt(i));

            if (s.length()-i < k){
                tmp.append(s.substring(i));
                sb.append(tmp.reverse());
                continue;
            }
            if (s.length() -i >=k && s.length()-i<2*k){
                tmp.append(s, i, i+k);
                sb.append(tmp.reverse());
                sb.append(s, i+k, s.length()-i);
            }
            if (s.length() -i >= 2*k){
                tmp.append(s, i, i+k);
                sb.append(tmp.reverse());
                sb.append(s, i+k, i+2*k);
            }
        }
        return sb.toString();
    }
}
