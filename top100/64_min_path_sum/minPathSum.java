class Solution 
{
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length;    // row
        int n = grid[0].length; // col
        
        // init row
        for (int i=1; i<m; i++)
            grid[i][0] = grid[i-1][0] + grid[i][0];
        
        // init col
        for (int j=1; j<n; j++)
            grid[0][j] = grid[0][j-1] + grid[0][j];
        
        // get rest
        for (int i=1; i<m; i++)
        {
            for (int j=1; j<n; j++)
                grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
        }
        
        // return last
        return grid[m-1][n-1];
    }
}