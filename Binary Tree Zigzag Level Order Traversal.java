/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        
        
        ArrayList<ArrayList<TreeNode>> results = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<ArrayList<Integer>> intResults = new ArrayList<ArrayList<Integer>>();
        
        if(root == null) {
            return intResults;
        }
        
        ArrayList<TreeNode> first = new ArrayList<TreeNode>();
        first.add(root);
        results.add(first);
        
        boolean reverse = true;
        int i = 0;
        //while(result.get(i) != null) {
        while(true) {
            ArrayList<TreeNode> parent = results.get(i);
            ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
            if(reverse) {
                for(int j = parent.size() - 1; j >= 0; j--) {
                    if(parent.get(j).right != null) {
                        cur.add(parent.get(j).right);
                    }
                    if(parent.get(j).left != null) {
                        cur.add(parent.get(j).left);
                    }
                    
                }
                
            }
            else {
                for(int j = parent.size() - 1; j >= 0; j--) {
                    if(parent.get(j).left != null) {
                        cur.add(parent.get(j).left);
                    }
                    if(parent.get(j).right != null) {
                        cur.add(parent.get(j).right);
                    }
                }
                
            }
            reverse = !reverse;
            if(cur.isEmpty()) {
                break;
            }
            results.add(cur);
            i++;
        }
        
        for(int k = 0; k < results.size(); k++) {
            ArrayList<TreeNode> temp = results.get(k);
            ArrayList<Integer> tempData = new ArrayList<Integer>();
            
            for(int m = 0; m < temp.size(); m++) {
                tempData.add(temp.get(m).val);
            }
            intResults.add(tempData);
        }
        
        return intResults;
    }
}