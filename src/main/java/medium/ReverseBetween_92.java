package medium;


public class ReverseBetween_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
/*        int count=1;
        ListNode cur=head,prev=null;
        ListNode temp,node1=null,node2=null;
        while(cur!=null){
            if (count==m){
                node1=prev;
                node2=cur;
            }
            if(count>m&&count<=n){
                if(count==n){
                    if (m==1){
                        head=cur;
                    }
                    if (node1!=null) {
                        node1.next = cur;
                    }
                    node2.next=cur.next;
                }
                temp=cur.next;
                cur.next=prev;
                prev=cur;
                cur=temp;
                count++;
            }
            else{
                prev=cur;
                cur=cur.next;
                count++;
            }
        }
        return head;*/
        ListNode prevhead=new ListNode(0);
        prevhead.next=head;
        ListNode prev=prevhead;
        for (int i=1;i<m;i++){
            prev=prev.next;
        }
        head=prev.next;
        for (int i=m;i<n;i++){
            ListNode cur=head.next;
            head.next=cur.next;
            cur.next=prev.next;
            prev.next=cur;
        }
        return prevhead.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode h2=new ListNode(2);
        /*ListNode h3=new ListNode(3);
        ListNode h4=new ListNode(4);
        ListNode h5=new ListNode(5);*/
        head.next=h2;
        h2.next=null;
        /*h2.next=h3;
        h3.next=h4;
        h4.next=h5;
        h5.next=null;*/
        System.out.println(head);
        ReverseBetween_92 r=new ReverseBetween_92();
        head=r.reverseBetween(head,1,2);
        System.out.println(head);

    }
}
