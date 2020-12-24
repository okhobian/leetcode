class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        int count = 0;
        for (int i=0; i<n; i++)
        {
            int prefixSum = 0;
            for (int j=i; j<n; j++)
            {
                prefixSum += nums[j];
                if (prefixSum == k)
                    count++;
            }
        }
        return count;
    }
}

/**
 * time = O(n^2)
 * space = O(1)
 */