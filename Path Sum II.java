/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        helper(root, 0, sum, new ArrayList<Integer>());
        return result;
    }
    
    public void helper(TreeNode root, int curSum, int target, ArrayList<Integer> list) {
        ArrayList<Integer> curList = new ArrayList<Integer>(list);
        if (root == null) {
            return;
        }
        curList.add(root.val);
        if (root.left == null && root.right == null) {
            if (curSum + root.val == target) {
                result.add(curList);
            }
        }
        
        helper(root.left, curSum + root.val, target, curList);
        helper(root.right, curSum + root.val, target, curList);
        
    }
}