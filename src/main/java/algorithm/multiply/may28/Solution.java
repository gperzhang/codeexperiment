package algorithm.multiply.may28;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);

        System.out.println(solution.pop());
        System.out.println(solution.pop());
        solution.push(4);
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if(stack2.size()==0 && stack1.size()==0){
            return -1;
        }
        if(stack2.size()==0){
            while (stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}
