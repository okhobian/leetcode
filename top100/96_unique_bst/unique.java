class Solution 
{
    public int numTrees(int n) 
    {
        int [] dp = new int[n+1];
        dp[0]= 1;   // 0 node, 1 possible structure
        dp[1] = 1;  // 1 node, 1 possible structure
        for(int i=2; i<=n; i++) // compute from 2 nodes to n nodes
            for(int j=0; j<i; j++)  // each look at how many on the left and how many on the right
                // number i as root, j nodes in left sub-tree, i-j-1 nodes in right sub-tree
                // dp[j] stores how many possible structures when there's j nodes
                // dp[i-j-1] stores how many possible structures when there's i-j-1 nodes
                dp[i] += dp[j] * dp[i-j-1];
        
        // dp[n] stores how many possible structures when there's n nodes
        return dp[n];
    }
}

/**
 * DP
 * 
 * Time = O(n^2)
 * Space = O(n)
 * 
 * https://www.youtube.com/watch?v=YDf982Lb84o&t=508s
 * 
 */