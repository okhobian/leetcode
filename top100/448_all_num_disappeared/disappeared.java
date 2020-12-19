class Solution 
{
    // public List<Integer> findDisappearedNumbers(int[] nums)
    // {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     List<Integer> res = new ArrayList<>();
    //     for (int i=0; i<nums.length; i++)
    //         if (nums[i] != 0) map.put(nums[i], 1);
    //     for (int i=1; i<=nums.length; i++)
    //     {
    //         if (map.get(i) == null)
    //             res.add(i);
    //     }
    //     return res;
    // }
    
    /**
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92980/5-line-Java-Easy-understanding
     * https://blog.csdn.net/qq_32641095/article/details/71576330
     * 
     */
    
    public List<Integer> findDisappearedNumbers(int[] nums) 
    {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n; i++) nums[(nums[i]-1) % n] += n;
        for (int i=0; i<n; i++) if (nums[i] <= n) res.add(i+1);
        return res;
    }
}