package algorithm.program.printListFromTailToHead;

/**
 * create by zj 2019-10-07
 */
public class ListNode {
    public int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public static void main(String[] args) {
       ListNode listNode = new ListNode(1);
       listNode.next = new ListNode(2);
       listNode.next.next = new ListNode(3);
       while(listNode!= null){
           System.out.println(listNode.val);
           listNode = listNode.next;
       }
    }
}
