package algorithm.multiply.june09;

public class Solution01 {

    public ListNode FindKthToTail(ListNode head,int k) {

        int fast =0,slow =0;
        ListNode fastNode = head,slowNode =head;
        while (fastNode!=null){
            if(fast==k){
                break;
            }
            fastNode =fastNode.next;
            fast++;
        }
        if(fast<k)return null;
        while (fastNode!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

}

