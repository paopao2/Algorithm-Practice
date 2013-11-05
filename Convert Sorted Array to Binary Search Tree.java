/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = num.length;
        
        if (length == 0) {
            return null;
        }
        return getNode(0, length - 1, num);
    }
    
    public TreeNode getNode (int start, int end, int[] num) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = getNode(start, mid - 1, num);
        root.right = getNode(mid + 1, end, num);
        return root;
    }
    
}