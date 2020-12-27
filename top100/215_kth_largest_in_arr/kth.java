class Solution 
{
    /**
    * priority queue method
    * O(nlogk)
    */
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int n : nums)
        {
            q.offer(n);
            if (q.size() > k)
                q.poll();
        }
        
        return q.peek();
    }
    
    
    
    // /**
    // * sort method
    // * O(nlogk)
    // */
    // public int findKthLargest(int[] nums, int k)
    // {
    //     Arrays.sort(nums);
    //     return nums[nums.length-k];
    // }
}