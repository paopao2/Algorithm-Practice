/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int preLength = preorder.length;
        int inLength = inorder.length;
        
        if (preLength != inLength) {
            return null;
        }
        
        return buildTreeHelper(preorder, inorder, 0, preLength - 1, 0, inLength - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        for(int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart - inStart + i, inStart, i - 1);
                root.right = buildTreeHelper(preorder, inorder, preEnd - inEnd + i + 1, preEnd, i + 1, inEnd);
            }
        }
        
        return root;
    }
}