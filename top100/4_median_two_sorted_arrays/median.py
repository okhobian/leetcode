class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        # step 1
        if len(nums1) > len(nums2):
            temp = nums1
            nums1 = nums2
            nums2 = temp
        
        # step 2
        len1 = len(nums1)
        len2 = len(nums2)
        lenCombine = len1 + len2
        
        # step 3
        low = 0
        high = len1
        
        # step 4
        while low <= high:
            # step 5
            partX = (low+high) // 2
            partY = (lenCombine + 1) // 2 - partX
            
            # step 6
            maxLeftX = float('-inf') if partX == 0 else nums1[partX-1]
            minRightX = float('inf') if partX == len1 else nums1[partX]
            maxLeftY = float('-inf') if partY == 0 else nums2[partY-1]
            minRightY = float('inf') if partY == len2 else nums2[partY]
            
            # step 7
            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                if lenCombine % 2 == 0:
                    return (max(maxLeftX, maxLeftY)+min(minRightX, minRightY)) / 2
                else:
                    return max(maxLeftX, maxLeftY)
            elif maxLeftX > minRightY:
                high = partX - 1
            else:
                low = partX + 1