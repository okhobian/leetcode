class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        new_max, maxi, step = 0, 0, 0
        for i in range(len(nums)-1):
            new_max = max(new_max, nums[i]+i)
            if i == maxi:
                step += 1
                maxi = new_max
                if maxi >= len(nums)-1:
                    break

        return step
        