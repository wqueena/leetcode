package medium;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fir=head,sec=head;
        for (int i=0;i<n;i++){
            sec=sec.next;
        }
        if (sec==null){
            return head.next;
        }
        while (sec.next!=null){
            sec=sec.next;
            fir=fir.next;
        }
        fir.next=fir.next.next;
        return head;
    }
}

/*
让两个指针之间始终保持n的距离，
当前面的指针指向空的时候，后面的指针指向的下一个节点即为要删除节点
 */