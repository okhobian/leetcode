class Solution 
{
    public List<String> generateParenthesis(int n) 
    {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }
    
    private void helper(List<String> res, String curr, int left, int right)
    {
        if (left == 0 && right == 0)
        {
            res.add(curr);
            return;
        }
        
        if (left > 0)
            helper(res, curr+"(", left-1, right);
        
        if (right > left)
            helper(res, curr+")", left, right-1);
    }
}

/**
 *    recursion tree: https://www.youtube.com/watch?v=XF0wh8M2A6E
 *    java code: https://www.cnblogs.com/grandyang/p/4444160.html
 *               https://www.youtube.com/watch?v=ptYZDPk2bOg&t=212s                                  
 *   
 */