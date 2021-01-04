/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public int rob(TreeNode root)
    {
        return Math.max( helper(root)[0], helper(root)[1] );
    }
    
    // int[0] = not rob, int[1] = rob
    private int[] helper(TreeNode root)
    {
        if (root == null) return new int[2];
        
        int[] curr = new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        curr[0] = Math.max( left[0], left[1] ) + Math.max( right[0], right[1] );
        curr[1] = root.val + left[0] + right[0];
        
        return curr;
    }
}