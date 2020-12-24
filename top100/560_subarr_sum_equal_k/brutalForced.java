class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        int count = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=i; j<n; j++)
            {
                int sum = 0;
                for (int index=i; index<=j; index++)
                    sum += nums[index];

                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}

/**
 * time = O(n^3)
 * space = O(1)
 */