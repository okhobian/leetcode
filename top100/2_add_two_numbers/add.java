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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode res = new ListNode();
        ListNode cur = res;
        int carry = 0;
        
        while (l1!=null && l2!=null)
        {
            
            if ( (l1.val + l2.val + carry) >= 10 )
            {
                cur.val = (l1.val+l2.val+carry-10);
                carry = 1;
            }
            else 
            {
                cur.val = l1.val + l2.val + carry;
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            
            if (l1!=null || l2!=null)
            {
                cur.next = new ListNode();
                cur = cur.next;
            }
        }
        
        while (l1!=null)
        {
            if ( (carry + l1.val) >= 10 )
            {
                cur.val = carry + l1.val - 10;
                carry = 1;
            }
            else 
            {
                cur.val = carry + l1.val;
                carry = 0;
            }
            
            if (l1.next != null)
            {
                cur.next = new ListNode();
                cur = cur.next;
            }
            l1 = l1.next;
        }
        
        while (l2!=null)
        {
            if ( (carry + l2.val) >= 10 )
            {
                cur.val = carry + l2.val - 10;
                carry = 1;
            }
            else 
            {
                cur.val = carry + l2.val;
                carry = 0;
            }
            if (l2.next != null)
            {
                cur.next = new ListNode();
                cur = cur.next;
            }
            l2 = l2.next;
        }
        
        if (carry == 1)
        {
            cur.next = new ListNode(1);
        }
        
        return res;
    }
}