# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
        
## stack approach
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        stack = []
        _head = head
        
        while head:
            stack.append(head.val)
            head = head.next
            
        while stack:
            if stack.pop() != _head.val:
                return False
            else:
                _head = _head.next
        
        return True
    
## fast&slow pointers and stack
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        fast = head
        slow = head
        stack = []
        
        while fast and fast.next:
            stack.append(slow.val)
            slow = slow.next
            fast = fast.next.next

        if fast:
            slow = slow.next
            
        while slow and stack:
            if stack.pop() != slow.val:
                return False
            slow = slow.next
            
        return True
    
## fast&slow pointers and reverse second half
## O(n) time and O(1) space
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        # edge case: [1]
        if not head or not head.next: return True
        
        fast = head
        slow = head
        
        # move pointers, slow@mid, fast@end
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        
        # second half starts at slow.next
        last = slow.next
        
        # swap one by one to revser the second half
        while last.next:
            temp = last.next
            last.next = temp.next
            temp.next = slow.next
            slow.next = temp
        
        # start from head & second half, compare one by one
        while slow.next:
            slow = slow.next
            if head.val != slow.val: 
                return False
            head = head.next
        
        return True