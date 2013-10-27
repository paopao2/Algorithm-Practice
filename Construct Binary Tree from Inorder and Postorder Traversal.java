/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = inorder.length;
        return buildTreeHelper(inorder, postorder, 0, length - 1, 0, length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] inorderTree, int[] postorderTree, int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart || postEnd < postStart) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorderTree[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorderTree[i] == root.val) {
                //inEnd - inStart == postEnd - postStart
                root.left = buildTreeHelper(inorderTree, postorderTree, inStart, i - 1, postStart, postStart - inStart + i - 1);
                root.right = buildTreeHelper(inorderTree, postorderTree, i + 1, inEnd, postEnd - inEnd + i, postEnd - 1);
            }
        }
        return root;
    }
}