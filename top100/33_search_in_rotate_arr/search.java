class Solution 
{
    public int search(int[] nums, int target) 
    {
        if (nums == null || nums.length == 0) 
            return -1;
        
        int pivot = nums.length-1;    
        
        for (int i=1; i<nums.length; i++)
        {
            if (nums[i] < nums[i-1])
                pivot = i-1;
        }
        
        if (target>=nums[0] && target<=nums[pivot])
            return binarySearch(target, nums, 0, pivot);
        else
            return binarySearch(target, nums, pivot+1, nums.length-1);            
    }
    
    private int binarySearch(int target, int[] nums, int left, int right)
    {
        while(left<=right)
        {
            int mid = left + (right - left) / 2;
            
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;            
        }
        return -1;
    }
}


/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */