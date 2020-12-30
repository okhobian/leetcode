class Solution 
{
    public int firstMissingPositive(int[] nums) 
    {
        if (nums.length == 0 || nums == null) return 1;
        
        Arrays.sort(nums);
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
          
        for (int i=1; i<=nums.length; i++)
        {
            if ( !set.contains(i) )
                return i;
        }
        
        return nums[nums.length-1]+1;
    }
}