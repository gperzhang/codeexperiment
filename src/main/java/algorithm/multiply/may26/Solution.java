package algorithm.multiply.may26;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        ArrayList<Integer> list = printListFromTailToHead(listNode);

        list.stream().forEach(a-> System.out.println(a));

    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (stack!=null &&stack.size()>0){
            list.add(stack.pop());
        }
        return list;
    }
}

 class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
