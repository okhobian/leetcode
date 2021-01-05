class Solution 
{

    /**
     * bucket sort
     * time = O(n)
     * space = O(n)
     */

    public void sortColors(int[] nums) 
    {
        int[] bucket = new int[3];
        for (int num : nums)
            bucket[num]++;
        
        for (int i=0, idx=0; i<3; i++)
        {
            for (int j=0; j<bucket[i]; j++)
                nums[idx++] = i;
        }        
    }
}