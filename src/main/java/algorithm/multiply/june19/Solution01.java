package algorithm.multiply.june19;

/**
 * 复制复杂链表
 */
public class Solution01 {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)return null;
        RandomListNode current = pHead;
        while(current!=null){
            RandomListNode node = new RandomListNode(current.label);
            node.next = current.next;
            current.next = node;
            current = current.next.next;
        }

        current = pHead;
        while (current!=null){
            if(current.random!=null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (current!=null){
            RandomListNode cur = current.next;
            current.next = cur.next;
            cur.next = current.next==null?null:current.next.next;
            current = current.next;
        }

//        current = pHead;
//        RandomListNode pCloneHead = pHead.next;
//        while(current != null) {
//            RandomListNode cloneNode = current.next;
//            current.next = cloneNode.next;
//            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
//            current = current.next;
//        }

        return pCloneHead;
    }
}
