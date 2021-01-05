class Solution 
{
    /**
     * bucket sort approach
     * time = O(n)
     * space = O(n)
     */

    public int[] topKFrequent(int[] nums, int k) 
    {
        // map --> element:frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        
        // bucket --> index=frequency; listAtIndex=elementsWithThisFreq
        ArrayList<Integer>[] list = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            if (list[freq] == null)
                list[freq] = new ArrayList();
            
            list[freq].add(num);
        }
        
        // result --> iterate from last (most freq), get up to k frequent elements
        // i: bucket array counter
        // j: result array counter
        // k: result array size
        // l: list at bucket[i] counter
        int[] res = new int[k];
        for (int i=list.length-1, j=0; i>0 && j<k; i--)
        {
            int l = 0;
            while (list[i]!=null && l<list[i].size())
            {
                res[j] = list[i].get(l);
                j++;
                l++;
            }
        }
    
        return res;
    }
}