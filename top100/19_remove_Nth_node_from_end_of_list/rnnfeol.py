# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        
        if not head:
            return head
        
        fast = head
        slow = head
        
        # fast move n times，fast stops at (n+1), N-(n+1) nodes left
        for _ in range(n):
            fast = fast.next
        
        # if fast is null, means N=n, simple delete head
        if not fast:
            return head.next
        
        # move fast & slow together until fast reaches the end
        # slow will stop at (N-n), which is nth-1 from backwards
        while fast.next:
            fast = fast.next
            slow = slow.next
            
        # delete slow's next one
        slow.next = slow.next.next
        
        return head