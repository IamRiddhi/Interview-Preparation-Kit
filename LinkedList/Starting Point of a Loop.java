/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null)
        {
            if(slow==fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast==null || fast.next==null)
            return null;
        
        slow = head;
        fast = fast.next;
        
        while(fast!=slow)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
