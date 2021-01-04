class Solution 
{
    private String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) 
    {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        
        StringBuilder sb = new StringBuilder();
        helper(digits, res, sb, 0);
        
        return res;
    }
    
    private void helper(String digits, List<String> res, StringBuilder sb, int depth)
    {
        if (depth == digits.length())
        {
            res.add(sb.toString());
            return;
        }
        
        String letters = keys[digits.charAt(depth) - '0'];
        for (int i=0; i<letters.length(); i++)
        {
            sb.append( letters.charAt(i) );
            helper(digits, res, sb, depth+1);
            sb.deleteCharAt( sb.length() - 1 );
        }
    }
}


/**
 * Time = O(4^n)
 * Space = O(n)
 * 
 * https://www.youtube.com/watch?v=iFP-xQhg6IU
 */