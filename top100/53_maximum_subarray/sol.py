class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        pre = 0
        maxAns = nums[0]
        
        for x in nums:
            pre = max(pre+x, x)
            maxAns = max(maxAns, pre)
        
        return maxAns