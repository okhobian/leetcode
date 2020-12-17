class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        
        for (int i=1; i<nums.length; i++)
        {
            int temp = max;
            max = Math.max( Math.max(max*nums[i], min*nums[i]), nums[i] );
            min = Math.min( Math.min(min*nums[i], temp*nums[i]), nums[i] );
            res = Math.max( res, max );
        }
        
        return res;
    }
}

/**
 * DP problem
 * 
 * need to consider three cases at each sub-problem:
 * 1. both negative
 * 2. both positive
 * 3. current number
 * 
 * explaination: https://www.youtube.com/watch?v=0Kpz-ChuQIE
 * 
 * /