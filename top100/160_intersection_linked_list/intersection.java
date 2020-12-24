/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        if (headA == null || headB == null) return null;
        
        ListNode ptr_a = headA;
        ListNode ptr_b = headB;
        
        // ensures either both reach null or intersect node
        while ( ptr_a != ptr_b )
        {
            ptr_a = (ptr_a == null) ? headB : ptr_a.next;
            ptr_b = (ptr_b == null) ? headA : ptr_b.next;
        }
        
        return ptr_a;
    }
}

/**
 * https://www.cnblogs.com/grandyang/p/4128461.html
 * https://www.youtube.com/watch?v=IpBfg9d4dmQ
 * 
 * O(n)
 */