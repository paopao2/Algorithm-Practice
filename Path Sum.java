/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

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
    public boolean hasPathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) {
            return false;
        }
        return helper(root, 0, sum);
    }
    
    public boolean helper(TreeNode root, int curSum, int target) {
        if (root == null) {
            return curSum == target;
        }
        if (root.left == null && root.right == null) {
            return helper(root.left, curSum + root.val, target) && helper(root.right, curSum + root.val, target);
        } else if (root.left == null) {
            return helper(root.right, curSum + root.val, target);
        } else if (root.right == null) {
            return helper(root.left, curSum + root.val, target);
        } else {
            return helper(root.left, curSum + root.val, target) || helper(root.right, curSum + root.val, target);
        }
    }
}