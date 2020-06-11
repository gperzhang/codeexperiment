package algorithm.multiply.june10;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        ListNode node = createNode(list);
//
//        ListNode listNode = reverseNode(node);
//
//        while(listNode!=null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        LinkedListUtils.addHead(1);
        LinkedListUtils.addHead(2);
        LinkedListUtils.addHead(3);
        LinkedListUtils.addHead(4);
        LinkedListUtils.addHead(5);

        ListNode node = LinkedListUtils.head;


//        int index = LinkedListUtils.findIndex(node, 6);
//        System.out.println(index);
        LinkedListUtils.delete(node,1);

        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }


    }

    /**
     * 通过list创建一个链表
     * @param list
     * @return
     */
    public static ListNode createNode(List<Integer> list){
        ListNode head,curNode,tempNode= null;
        curNode = head = new ListNode(list.get(0));
        for(int i=1;i<list.size();i++){
            tempNode = new ListNode(list.get(i));
            curNode.next = tempNode;
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 将链表反转
     * @param head
     * @return
     */
    public static ListNode reverseNode(ListNode head){
        ListNode dummy=new ListNode(-1),pre=null,cur=null;
        if(head==null)return head;
        dummy.next = head;
        pre = head;
        cur = pre.next;
        while(cur!=null){
            pre.next = cur.next;
            cur.next= dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }

        return dummy.next;
    }
    /**
     * 将链表反向输出
     */
    public static void reversePrint(ListNode head){
        if(head == null){
            return;
        }else {
            reversePrint(head.next);
            System.out.println(head.val);
        }
    }


}


class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
