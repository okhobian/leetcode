class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int m = word1.length(); // m = word1.len
        int n = word2.length(); // n = word2.len
        
        if (m == 0) return n;   // word1 is empty
        if (n == 0) return m;   // word2 is empty
        
        int[][] dp = new int[m+1][n+1];
        
        for (int i=0; i<=m; i++) dp[i][0] = i;
        for (int j=0; j<=n; j++) dp[0][j] = j;
        
        for (int i=1; i<=m; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]; // no change
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                                    // insertion:   [i][j-1]
                                    // deletion:    [i-1][j]
                                    // replcement:  [i-1][j-1]
                                    // +1: plus current above operation
                }
            }
        }      
        
        return dp[m][n];
    }
}