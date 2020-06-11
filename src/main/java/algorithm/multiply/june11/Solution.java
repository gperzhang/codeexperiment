package algorithm.multiply.june11;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        if(list1==null && list2==null)return null;
        while(list1!=null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2!=null){
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        ListNode head,curNode,tempNode= null;
        curNode = head = new ListNode(list.get(0));
        for(int i=1;i<list.size();i++){
            tempNode = new ListNode(list.get(i));
            curNode.next = tempNode;
            curNode = curNode.next;
        }
        return head;
    }
}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}




