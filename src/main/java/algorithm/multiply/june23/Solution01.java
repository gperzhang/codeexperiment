package algorithm.multiply.june23;

import java.util.Stack;

/**
 * 要求时间复杂度为O(1)
 */
public class Solution01 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else {
            if(node<minStack.peek()){
                minStack.push(node);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
