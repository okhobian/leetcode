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


 /**
  * Stack approach
  * https://www.youtube.com/watch?v=v2ob-ek9TgE&t=237s
  */
class Solution 
{
    public void flatten(TreeNode root) 
    {
        if (root==null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode curr = stack.pop();
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
            
            if (!stack.isEmpty()) curr.right = stack.peek();
            curr.left = null;
        }
    }
}

/**
 * Divide and Conquer approach
 * https://www.youtube.com/watch?v=pVOVJ8F_A_A
 */
class Solution 
{
    public void flatten(TreeNode root) 
    {
        divideConquer(root);
    }
    
    private TreeNode divideConquer(TreeNode root)
    {
        if (root == null) return null;
        
        TreeNode leftPrev = divideConquer(root.left);
        TreeNode rightPrev = divideConquer(root.right);
        
        if (leftPrev != null)
        {
            leftPrev.right = root.right;
            root.right = root.left;
            root.left = null;
        }
                
        if (rightPrev != null) return rightPrev;
        if (leftPrev != null) return leftPrev;
        return root;
    }
}