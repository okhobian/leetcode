class Solution 
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int index)
    {
        res.add(new ArrayList<>(subset));
        for (int i=index; i<nums.length; i++)
        {
            subset.add(nums[i]);
            dfs(res, subset, nums, i+1);
            subset.remove(subset.size()-1);
        }
    }
}


/**
 * DFS, Backtracking
 * 
 * O(N*2^N)
 */