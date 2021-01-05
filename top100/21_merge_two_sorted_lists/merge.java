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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1==null) return l2;
        if (l2==null) return l1;
        
        ListNode resHead = new ListNode();
        ListNode curr = resHead;
        
        while (l1 != null && l2 != null)
        {
            if (l1.val > l2.val)
            {
                curr.next = l2;
                l2 = l2.next;
            }
            else 
            {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        
        curr.next = (l1==null) ? l2 : l1;
        
        return resHead.next;
    }
}


/**
 * https://www.youtube.com/watch?v=BRkc1tHKc8E
 */