/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if (head==null)
        return false;
    Node slow = head;
    Node fast = null;
    if(head.next!=null)
        fast = slow.next;
    else
        return false;
    while(fast!=null && fast!=slow )
    {
        fast = fast.next;
        if(fast!=null)
            fast = fast.next;
        slow = slow.next;
    }
    if(fast==null)
        return false;
    else
        return true;
}