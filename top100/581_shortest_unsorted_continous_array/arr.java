class Solution 
{
    public int findUnsortedSubarray(int[] nums) 
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i=1; i<nums.length; i++)
        {
            if (nums[i] < nums[i-1])
                min = Math.min( min, nums[i] );
        }
        
        for (int i=nums.length-2; i>=0; i--)
        {
            if (nums[i] > nums[i+1])
                max = Math.max( max, nums[i] );
        }
        
        for (int i=0; i<nums.length; i++)
        {
            if (min < nums[i]){
                min = i;
                break;
            }
        }
        
        for (int i=nums.length-1; i>=0; i--)
        {
            if (max > nums[i]){
                max = i;
                break;
            }
        }
        
        return (min > max) ? 0 : (max - min + 1);
    }
}


/**
 * Time = O(n)
 * Space = O(1)
 */