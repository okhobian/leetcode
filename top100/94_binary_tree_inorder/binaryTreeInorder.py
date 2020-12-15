# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        stack = []
        
        curr = root
        while curr is not None:
            if curr.left is not None:
                stack.append(curr)
                curr = curr.left
            else:
                result.append(curr.val)
                while len(stack) != 0 and curr.right is None:
                    node = stack.pop()
                    result.append(node.val)
                    curr = node
                curr = curr.right
        
        return result