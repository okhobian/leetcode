# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.divideConquer(root)
    
    def divideConquer(self, root: TreeNode):
        if not root:
            return None
        
        left = self.divideConquer(root.left)
        right = self.divideConquer(root.right)
        
        if left:
            left.right = root.right
            root.right = root.left
            root.left = None
        
        if right:
            return right
        if left:
            return left
        return root