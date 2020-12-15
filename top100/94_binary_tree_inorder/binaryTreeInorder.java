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
    /* Inorder: left-root-right */
    /* stack maintains the execution order in recursion */
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        while (curr != null)
        {
            if (curr.left != null)  // add left branch all the way down
            {
                stack.push(curr);
                curr = curr.left;
            }
            else                    // reaches the left leaf
            {
                result.add(curr.val);   // add left leaf to result
                while (!stack.isEmpty() && curr.right == null)  
                    // backtrack to root until a right presents
                {
                    TreeNode currParent = stack.pop();
                    result.add(currParent.val); // indorder add root in middle
                    curr = currParent;
                }
                curr = curr.right;              // visit right last
            }
        }        
        return result;
    }
    
}