package algorithm.program.stacktoqueue;

public class QueueTest {
    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.push(1);
        stack2Queue.push(2);
        stack2Queue.push(3);

        System.out.println(stack2Queue.pop());
        System.out.println(stack2Queue.pop());

    }
}
