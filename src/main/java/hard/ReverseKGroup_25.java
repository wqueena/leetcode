package hard;

public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len=0;
        ListNode node=head;
        while (node!=null){
            len+=1;
            node=node.next;
        }
        int times=len/k;
        node=null;
        ListNode cur=head,prev=null,temp,node1;
        for (int i=0;i<times;i++){
            node1=cur;
            for (int j=0;j<k;j++){
                temp=cur.next;
                cur.next=prev;
                prev=cur;
                if (node!=null){
                    node.next=cur;
                }
                if (i==0){
                    head=cur;
                }
                cur=temp;
            }
            node=node1;
        }
        node.next=cur;
        return head;
    }
}
