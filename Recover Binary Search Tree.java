/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Straight forward approach:
Inorder traverse the tree, put the nodes in a treenode list and the values in an integer list.
Sort the value list and update the treenode list's values one by one.
*/
/*
Inorder traverse, keep the previous tree node,
Find first misplaced node by
if ( current.val < prev.val )
   Node first = prev;

Find second by
if ( current.val < prev.val )
   Node second = current;

After traversal, swap the values of first and second node. Only need two pointers, prev and current node. O(1) space.
*/
public class Solution {
    ArrayList<TreeNode> track;
    TreeNode previous;
    public void recoverTree(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        track = new ArrayList<TreeNode>();
        previous = null;
        inorderTraverse(root);
        
        int size = track.size();
        int temp = track.get(0).val;
        track.get(0).val = track.get(size - 1).val;
        track.get(size - 1).val = temp;
    }
    
    public void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        if (previous != null && previous.val > root.val) {
            if (!track.contains(previous)) {
                track.add(previous);
            }
            if (!track.contains(root)) {
                track.add(root);
            }
        }
        previous = root;
        inorderTraverse(root.right);
    }
}
