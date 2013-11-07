/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    int sum;
    public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        sum = 0;
        if (root == null) {
            return sum;
        }
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode root, int curSum) {
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum = sum + curSum;
        } 
        if (root.left != null) {
            helper(root.left, curSum);
        } 
        if (root.right != null) {
            helper(root.right, curSum);
        } 
    }
}