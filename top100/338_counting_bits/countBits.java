class Solution 
{
    public int[] countBits(int num) 
    {
        int[] result = new int[num+1];
        for (int i=1; i<=num; i++)
            result[i] = result[i/2] + i%2;  // OR result[i>>1] + (i&1);
        return result;
    }
    
    /**
     * Even number: last bit always 0
     * Odd  number: last bit always 1
     * 
     * Even number / 2 ==> right shift binary by 1 bit ==> always has the same number of bits as Num/2
     * Odd  number / 2 ==> right shift binary by 1 bit ==> always has one more 1 in the end than Num/2
     * 
     * Thus, the recurrence is: result[i] = result[i/2] + i%2
     * Using DP, skip first number (0) since it always has zero 1    
     * 
     * https://www.youtube.com/watch?v=awxaRgUB4Kw 
     * /
}