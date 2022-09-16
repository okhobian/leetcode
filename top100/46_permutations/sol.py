class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        visited = {}
        for num in nums:
            visited[num] = False
        
        def dfs(curr):
            if len(curr) == len(nums):
                res.append(curr)
                return
            for num in nums:
                if not visited[num]:
                    visited[num] = True
                    dfs(curr + [num])
                    visited[num] = False
        
        dfs([])
        return res
    
########################################################################
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        visited = [0] * len(nums)
        
        def dfs(curr):
            if len(curr) == len(nums):
                res.append(curr)
                return
            for i in range(len(nums)):
                if not visited[i]:
                    visited[i] = True
                    dfs(curr + [nums[i]])
                    visited[i] = False
        
        dfs([])
        return res