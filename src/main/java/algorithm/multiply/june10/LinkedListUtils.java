package algorithm.multiply.june10;

public class LinkedListUtils {
    public static ListNode head;
    public static ListNode tail;

    public static ListNode addTail(int val){
        if(head==null){
            tail = head =new ListNode(val);
        }else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return head;
    }

    public static ListNode addHead(int val) {
        if (head == null) {
            tail = head = new ListNode(val);
        } else {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static int findIndex(ListNode head,int index){
        if(head==null){
            return -1;
        }
        int count =0;
        while (head!=null){
            if(count==index){
                return head.val;
            }
            count++;
            head = head.next;
        }
        return -1;
    }

    public static boolean delete(ListNode head,int index){
        if(head==null)return false;
        if(index==0){head=head.next;}
        int count = 0;
        while(head !=null){
            if(count==index-1){
                if(head.next.next ==null){
                 head.next = null;
                }else {
                    head.next = head.next.next;
                }
                break;
            }
            count++;
        }
        return true;
    }

    public static boolean deleteVal(int val){
        return true;
    }
}
