package offer;

/**
 * @Author:queena
 * @Date:2020/5/272155
 * @Description:
 */
public class ReversePrint_6 {
  public int[] reversePrint(ListNode head) {
    int len=0;
    ListNode prev=null;
    while (head!=null){
      ListNode temp=head.next;
      head.next=prev;
      prev=head;
      head=temp;
      len++;
    }
    int[] res=new int[len];
    for (int i=0;i<len;i++){
      res[i]=prev.val;
      prev=prev.next;
    }
    return res;
  }
}
