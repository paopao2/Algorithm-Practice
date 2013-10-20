/*Given a binary tree, find its maximum depth.*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(root == null)
            return 0;
        else {
            int leftDepth = 1 + maxDepth(root.left);
            int rightDepth = 1 + maxDepth(root.right);
            
            return (leftDepth > rightDepth)? leftDepth : rightDepth;
            
        }
    }
}