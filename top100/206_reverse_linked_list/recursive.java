/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode reverseList(ListNode head)
    {       
        // recursively
        return reverse(head, null);
    }
    
    private ListNode reverse(ListNode head, ListNode newHead)
    {
        if (head == null) return newHead;
        
        ListNode temp = head.next;
        head.next = newHead;
        newHead = head;
        head = temp;
        
        return reverse(head, newHead);
    }
}