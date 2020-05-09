package medium;

public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while (true){
            if (slow==null||fast==null||fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                slow=head;
                break;
            }
        }
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}

/*
这题也有两种方法，跟141类似
1.第一种快慢指针的方法，设链表非环长为a，环长为b，慢指针走了s，快指针走了2s。
两个指针相差的步数一定为n倍的环长，即s=nb，即2s=nb，而快指针走过的环的步数为2s-a（即nb-a），
即快指针距离环交叉点仅有a的步数，因此将满指针指向头，再让两个指针都每次走一步直到遇到。
2.第二种方法同141的第二种方法，返回Set中第一次重复的节点即可。
 */
