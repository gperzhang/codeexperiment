package algorithm.program.printListFromTailToHead;

import java.util.ArrayList;

/**
 * create by zj 2019-10-07
 */
public class Main {
    public static void main(String[] args) {

    }
    //利用stack的先进后出的特性
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (listNode!=null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        while(!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;
//    }
    //利用递归的倒序的特点
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> array = new ArrayList<>();
        if (listNode==null){
            return array;
        }
        printListFromTailToHead(listNode.next);
        array.add(listNode.val);
        return array;
    }
}
