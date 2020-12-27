class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        if (nums == null || nums.length < 3) 
            return new ArrayList<>();           // edge cases
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);                      // sort to increasing order
        
        for (int i=0; i<nums.length-2; i++)     // skip last (where right index starts)
        {
            if (i != 0 && nums[i] == nums[i-1]) 
                continue;                       // index i duplicated (skip same numbers)
            
            int left = i + 1;                   // left starts behind i
            int right = nums.length - 1;        // right starts from largest
            
            while (left < right)                // iterate towards center
            {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0)                   // got result
                {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left+1])
                        left++;                 // skip duplicate numbers for index left
                    left++;                     // skip one more to start after the same number

                    while (left < right && nums[right] == nums[right-1])
                        right--;                // skip duplicate numbers for index right
                    right--;                    // skip one more
                }
                else if (sum > 0)               // only way to decrease is to shift right  
                    right--;                    // (decrease max)
                else if (sum < 0)               // only way to increase is to shift left
                    left++;                     // (increase min)
            }
        }
        return res;
    }
}