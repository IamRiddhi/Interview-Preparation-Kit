/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode t3 = null;
        ListNode t4 = null;
        int carry = 0;
        while(t1!=null && t2!=null)
        {
            int x = t1.val + t2.val + carry;
            carry = x/10;
            x = x%10;
            if(t3==null)
            {
                t3 = new ListNode(x);
                t4 = t3;
            }
            else
            {
                t4.next = new ListNode(x);
                t4 = t4.next;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1!=null) 
        {
            int x = t1.val+carry;
            carry=x/10; x=x%10;
            t4.next = new ListNode(x);
            t4 = t4.next;
            t1=t1.next;
        }
         while(t2!=null) 
        {
            int x = t2.val+carry;
            carry=x/10; x=x%10;
            t4.next = new ListNode(x);
            t4 = t4.next;
            t2=t2.next;
        }
        if(carry>0)
            t4.next = new ListNode(carry);
        return t3;
    }
}