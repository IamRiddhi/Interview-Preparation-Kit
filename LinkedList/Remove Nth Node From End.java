/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        for(int i=1;i<=n;i++)
        {
            temp = temp.next;
            if(temp==null)
                return head.next;
        }
        ListNode x = head;
        ListNode prev = null;
        while(temp!=null)
        {
            prev = x;
            x = x.next;
            temp = temp.next;
        }
        
        prev.next = x.next;
        
        return head;
    }
}
