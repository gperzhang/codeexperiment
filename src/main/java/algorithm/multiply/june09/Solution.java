package algorithm.multiply.june09;

public class Solution {

    public static void main(String[] args) {
    }

    public ListNode FindKthToTail(ListNode head,int k) {

        int size = getSize(head);
        int count =0;
        while (head!=null){
            if(count==size-k){
                return head;
            }
            head = head.next;
            count++;
        }
        return null;
    }

    private int getSize(ListNode head) {

        int size = 0;
        while (head!=null){
            head = head.next;
            size++;
        }
        return size;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}