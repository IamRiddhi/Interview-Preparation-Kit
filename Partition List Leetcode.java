/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
   public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode small = new ListNode(0);
        ListNode  large = new ListNode(0);
        ListNode smallTail = small;
        ListNode largeTail = large;
        while(head!=null)
        {
            if(head.val<x)
            {
                smallTail.next = head;
                smallTail = head;
            }
            else
            {
                largeTail.next = head;
                largeTail = head;
            }
            ListNode prev = head;
            head = head.next;
            prev.next = null;
        }
        smallTail.next = large.next;
        return small.next;
    }
}
