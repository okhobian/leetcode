class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start)
    {
        if (target < 0) return;
        if (target == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=start; i<candidates.length; i++)
        {
            temp.add(candidates[i]);
            helper(candidates, target-candidates[i], res, temp, i);
            temp.remove(temp.size()-1);
        }
    }
}


/**
 * DFS backtracking
 * 
 * https://www.youtube.com/watch?v=6BmmaS3n-Q8&t=348s
 * https://www.youtube.com/watch?v=MTI2wc8s0BY&t=526s
 * 
 * Time complexity is O(N^target) where N is a length of candidates array.
 * Space complexity is O(target).
 */