package algorithm.program;

/**
 * Created by zj on 2020-01-15
 */
public class Solution {
    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null || pHead.next == null){
            return pHead;
        }
        ListNode node = pHead.next;
        if (pHead.val == node.val){
            while(node !=null && pHead.val == node.val)
                node = node.next;
            return deleteDuplication(node);

        }else {
            pHead.next =deleteDuplication(node);
            return pHead;
        }

    }
}
