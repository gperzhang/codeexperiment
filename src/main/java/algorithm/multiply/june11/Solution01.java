package algorithm.multiply.june11;

/**
 * 将两个单调递增的链表合并成一个非递减的链表
 */
public class Solution01 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        else if(list2==null)return list1;

        ListNode mergeNode = null;
        ListNode cur = null;
        while (list1!=null && list2!=null){
            if(list1.val<=list2.val){
                if(mergeNode==null){
                    cur = mergeNode = list1;
                }else {
                    cur.next = list1;
                    cur = cur.next;
                }
               list1 = list1.next;
            }else {
                if(mergeNode==null){
                    cur = mergeNode = list2;
                }else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            cur.next = list2;
        }else{
            cur.next = list1;
        }
        return mergeNode;
    }
}
