package easy;

public class ReverseList_24 {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,cur=head,temp;
        while (cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
