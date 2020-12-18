class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int max = nums[0];
        for (int i=0; i<nums.length; i++)
        {
            if (i > max) return false;
            int curMax = i + nums[i];
            max = Math.max(max, curMax);
        }
        return true;
    }
}

/**
 * Greedy aproach
 * https://blog.csdn.net/fuxuemingzhu/article/details/83504437
 * https://www.youtube.com/watch?v=oi3L2OAeU8M
 */