class Solution 
{
    
    /**
    * deque, monotonic queue
    * https://blog.csdn.net/xudli/article/details/46955257
    * https://www.youtube.com/watch?v=2SXqBsTR6a8
    */
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if (k==0) return new int[0];
        
        LinkedList<Integer> q = new LinkedList<Integer>();
 
        int[] res = new int[nums.length-k+1];
        
        
        // iterate through every number/index
        // for every new number, remove every number that is less than it
        // maintain a desendent order list
        for (int i=0; i<nums.length; i++) 
        {
            // remove every number that is less than current number from list
            while (!q.isEmpty() && nums[i]>=nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            
            if (i-q.getFirst()+1 > k)   // if the first is out of the window
                q.removeFirst();
            
            if (i+1>=k)                  // if there's enough in the window
                res[i-k+1] = nums[q.getFirst()];
        }
        
        return res;
    }
    
    
    
    /**
    * Brutal forced approach 
    * O(n*k)
    */
//     public int[] maxSlidingWindow(int[] nums, int k) 
//     {
//         int[] res = new int[nums.length-k+1];
//         for (int i=0; i<nums.length-k+1; i++)
//         {
//             int max = nums[i];
//             for (int j=i; j<i+k; j++)
//             {
//                 if (nums[j] > max)
//                     max = nums[j];
//             }
//             res[i] = max;
                
//         }
//         return res;
//     }
    
    
}