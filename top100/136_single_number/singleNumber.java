class Solution
{
    public int mySingleNumber(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
        {
            if (map.get(nums[i]) != null)
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        
        for (Map.Entry e : map.entrySet()) 
        { 
            if ((int)e.getValue() == 1)
                return (int) e.getKey();
        } 
        return 0;
    }
    
    public int singleNumber(int[] nums)
    {
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }
}