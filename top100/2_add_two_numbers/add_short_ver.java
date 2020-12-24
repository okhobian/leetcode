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
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int carry = 0;
        
        while (l1!=null || l2!=null)
        {
            // get current numbers
            int a = (l1==null) ? 0 : l1.val;
            int b = (l2==null) ? 0 : l2.val;
            
            // calculate sum
            int sum = a + b + carry;
            
            // update cur
            cur.next = new ListNode(sum%10);
            
            // update carry
            carry = sum / 10;
            
            // shift pointers
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // last bit
        cur.next = (carry==0) ? null : new ListNode(1);
        
        return res.next;
    }
}