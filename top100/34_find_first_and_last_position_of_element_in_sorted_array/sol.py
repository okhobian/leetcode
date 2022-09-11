class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        n = len(nums)
        
        if n == 0:
            return [-1, -1]
        
        low = self.lower_bound(nums, n, target)
        
        if low == -1:
            return [-1, -1]
        
        high = self.higher_bound(nums, n, target)
        
        return [low, high]
        
        

    def lower_bound(self, nums, size, target):
        low = 0
        high = size - 1
        
        while low < high:
            mid = (low+high) // 2
            
            if target > nums[mid]:
                low = mid + 1
            else:
                high = mid
        
        if nums[low] != target:
            return -1
        
        return low
    
    def higher_bound(self, nums, size, target):
        low = 0
        high = size - 1
        
        while low < high:
            mid = (low+high+1) // 2
            
            if nums[mid] > target:
                high = mid - 1
            else:
                low = mid
                
        if nums[low] != target:
            return -1
        
        return low
        
        
        