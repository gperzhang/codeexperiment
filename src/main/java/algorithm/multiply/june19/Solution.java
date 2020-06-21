package algorithm.multiply.june19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复杂链表的复制
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        while (pHead!=null){
            list.add(pHead.label);
            map.put(pHead.label,pHead.random.label);
            pHead = pHead.next;
        }
        RandomListNode head = null;
        RandomListNode cur = null;

        for (Integer integer : list) {
            if(head==null){
                head = new RandomListNode(integer);
                cur = head;
            }
            cur.next = new RandomListNode(integer);
        }
        return head;
    }
}



class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
