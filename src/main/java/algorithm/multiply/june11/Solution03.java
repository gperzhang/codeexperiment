package algorithm.multiply.june11;

public class Solution03 {
    public ListNode Merge(ListNode list1, ListNode list2){
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode mergeNode = null;
        if(list1.val<list2.val){
            mergeNode = list1;
            ListNode merge = Merge(list1.next, list2);
            mergeNode.next = merge;
        }else {
            mergeNode = list2;
            ListNode merge = Merge(list1, list2.next);
            mergeNode.next = merge;
        }
        return mergeNode;
    }
}
