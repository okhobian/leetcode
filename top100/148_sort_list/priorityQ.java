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
    public ListNode sortList(ListNode head) 
    {
        if (head == null || head.next == null) return head;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        
        while (head != null)
        {
            q.add(new ListNode(head.val));
            head = head.next;
        }
        
        while (!q.isEmpty())
        {
            temp.next = q.poll();
            temp = temp.next;
        }
        
        return dummy.next;
    }
}

/**
 * Min-heap
 * Time = O(nlog n)
 * Space = O(n)
 */