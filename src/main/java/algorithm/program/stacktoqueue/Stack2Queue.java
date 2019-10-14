package algorithm.program.stacktoqueue;

import java.util.Stack;

public class Stack2Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(Integer s1){
        stack1.push(s1);
    }

    public Integer pop(){
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
