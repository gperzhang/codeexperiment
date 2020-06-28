package algorithm.multiply.june23;

import java.util.Optional;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        Optional<Integer> min1 = stack.stream().min(Integer::compareTo);
        return min1.get();
    }
}
