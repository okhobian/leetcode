class Solution 
{
    /*
        solution found at https://www.youtube.com/watch?v=LPFhl65R7ww
        O(log(min(M,N)))
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        /*******************************
        * Step 1: swap to shorter array
        *******************************/
        if (nums1.length > nums2.length)    // swap to perform on the shorter array
        {                                   // nums1 always the short one
            int[] temp = nums1;             // always perform on nums1
            nums1 = nums2;
            nums2 = temp;
        }
        
        /*******************************
        * Step 2: get lengths
        *******************************/
        int len1 = nums1.length;
        int len2 = nums2.length;
        int lenCombine = len1 + len2;
        
        /*******************************
        * Step 3: initiate start/end
        *******************************/
        int start = 0;
        int end = len1;
        
        
        /*******************************
        * Step 4: while loop
        *******************************/
        while (start <= end)
        {    
            /*******************************
            * Step 5: calculate partX/partY (Kth)
            *******************************/
            int partX = (start + end) / 2;            // how many elements to look at on left in nums1
            int partY = (lenCombine + 1) / 2 - partX; // how many elements to look at on left in nums2
                                                      // partX + partY = (lenCombine+1) / 2

            /*******************************
            * Step 6: calculate maxLeft/minRight
            *******************************/
            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX-1];
            int minRightX = (partX == len1) ? Integer.MAX_VALUE : nums1[partX];
            
            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY-1];
            int minRightY = (partY == len2) ? Integer.MAX_VALUE : nums2[partY];
            
            /*******************************
            * Step 7: compare and adjust
            *******************************/
            if (maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                return (lenCombine % 2 == 0) ? (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0
                    : Math.max(maxLeftX, maxLeftY);
            }
            else if (maxLeftX > minRightY)
                end = partX - 1;
            else
                start = partX + 1;
        }
        
        return -1;
    }
    
    
    /* direct solution using java built-in functions
    * O(M+N)
    * but works with unsorted arrays and easy implementation
    */
//     public double myFindMedianSortedArrays(int[] nums1, int[] nums2) 
//     {
//         int len1 = nums1.length;
//         int len2 = nums2.length;
        
//         int[] merged = new int[len1+len2];
        
//         System.arraycopy(nums1, 0, merged, 0, len1);
//         System.arraycopy(nums2, 0, merged, len1, len2);
        
//         Arrays.sort(merged);        
//         if (merged.length % 2 == 0)
//             return (merged[merged.length/2] + merged[merged.length/2-1])/2.0;            
//         else
//             return merged[merged.length/2];        
//     }
}