class Solution
{
    public int longestConsecutive(int[] nums) 
    {
        if (nums.length < 2) return nums.length;
        
        Arrays.sort(nums);
        
        int max = 1;
        int cnt = 1;
        for (int i=1; i<nums.length; i++)
        {
            int diff = nums[i] - nums[i-1];
            if (diff == 0) continue;
            cnt = (diff==1) ? cnt+1 : 1;
            max = Math.max(cnt, max);
        }
        
        return max;
    }
}


/**
 * nlog n
 */