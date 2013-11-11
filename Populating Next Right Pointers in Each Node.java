/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) {
            return;
        }
        ArrayList<TreeLinkNode> levelList = new ArrayList<TreeLinkNode>();
        levelList.add(root);
        
        while (!levelList.isEmpty()) {
            ArrayList<TreeLinkNode> nextLevel = new ArrayList<TreeLinkNode>();
            for (int i = 0; i < levelList.size(); i++) {
                levelList.get(i).next = (i + 1 == levelList.size()) ? null : levelList.get(i + 1);
                if (levelList.get(i).left != null) {
                    nextLevel.add(levelList.get(i).left);
                }
                if (levelList.get(i).right != null) {
                    nextLevel.add(levelList.get(i).right);
                }
            }
            levelList = nextLevel;
        }
    }
}