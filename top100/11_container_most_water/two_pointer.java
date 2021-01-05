class Solution 
{
    public int maxArea(int[] height) 
    {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        
        while (left < right)
        {
            int h = Math.min(height[left], height[right]);
            int l = right - left;
            max = Math.max(max, h*l);
            
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        
        return max;
    }
}


/**
 * x-axis only decreases
 * so keep the higher bar for the next round to seek bigger area
 * 
 * https://www.youtube.com/watch?v=lK8fEghxJ0c
 */