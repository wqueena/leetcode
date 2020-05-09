package easy;

public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
    /*
    1.第一种方法为快慢指针（这个方法比较巧妙），
    快指针每次走两步，慢指针每次走一步，如果链表有环，则两个指针必定会相遇。
    时间复杂度为O(n),空间复杂度为O(1)
    2.另一种方法较为常规，也是遍历一遍链表，并将节点存在一个Set中，
    如果当节点在Set中已存在时，有环，返回True，
    否则遍历完后返回False。
    时间复杂度为O(n),空间复杂度为O(n)
     */
}
