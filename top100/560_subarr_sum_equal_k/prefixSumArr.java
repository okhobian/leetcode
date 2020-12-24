class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for (int num : nums)
        {
            prefixSum += num;
            count += map.getOrDefault(prefixSum-k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        
        return count;
    }
}




/**
 * time = O(n)
 * 
 * 
 * prefixSum[x] = prefixSum[x-1] + nums[x]
 * 
 * sum of subarry (i,j) = prefixSum[j] - prefixSum[i-1]
 * 
 * For each j, find how many pairs of (i,j), where i<j, (prefixSum[j] - prefixSum[i] == k)
 * 
 * https://www.youtube.com/watch?v=aYfwus5T3Bs
 * 
 */