class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxReach = nums[0]
        for i, num in enumerate(nums):
            if i > maxReach:
                return False
            maxReach = max(maxReach, i+num)
        return True