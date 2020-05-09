package medium;

public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode res=head.next,cur=head.next,prev=head,temp,node=null;
        while (cur!=null){
            if (node!=null){
                node.next=cur;
            }
            temp=cur.next;
            cur.next=prev;
            node=prev;
            if (temp==null||temp.next==null){
                node.next=temp;
                break;
            }
            prev=temp;
            cur=temp.next;
        }
        return res;
    }
}

/*
cur和prev指针都每次走两步，
另外再用一个node节点来记录上一次的prev节点以指向这一次的cur节点将两辆连接起来
 */