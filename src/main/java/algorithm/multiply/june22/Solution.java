package algorithm.multiply.june22;
import java.util.Stack;

/**
 * 判断是否为栈的弹出顺序
 */
public class Solution {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int p=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[p]){
                stack.pop();
                p++;
            }
        }
        return p==popA.length;
    }
}
