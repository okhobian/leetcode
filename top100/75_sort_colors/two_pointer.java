class Solution 
{
    /**
     * two pointers
     * Time = O(n)
     * Space = O(1)
     */

    public void sortColors(int[] nums) 
    {
        if (nums==null || nums.length==0) return;
        
        int zero = -1;
        int two = nums.length;
        int i = 0;
        
        while (i<two)
        {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2)
            {
                two--;
                swap(nums, i, two);
            }
            else
            {
                zero++;
                swap(nums, i, zero);
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * https://www.youtube.com/watch?v=aVOm2Kickys
 */