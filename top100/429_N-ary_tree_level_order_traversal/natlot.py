"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        
        if not root: return []              # return [] if root is null
        
        res = []
        q = collections.deque()             # deque from collections, FI left O
        q.append(root)                      # add root to queue
        
        while q:                            # when there's any node in queue
            level = []                      # current level list
            size = len(q)                   # get the length of the current q
            for _ in range(size):           # only iterate over current level (prevent inf loop with children added)
                node = q.popleft()          # pop the first in
                level.append(node.val)      # append each node at current level
                for child in node.children: # go over this node's children
                    q.append(child)         # add its children to the queue
            res.append(level)               # add the level to the res
                
        return res
                
                
                
    
        
        