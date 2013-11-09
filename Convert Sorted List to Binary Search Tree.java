/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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

/*
O(N) solution:

BinaryTree* sortedListToBST(ListNode *& list, int start, int end) {
  if (start > end) return NULL;
  // same as (start+end)/2, avoids overflow
  int mid = start + (end - start) / 2;
  BinaryTree *leftChild = sortedListToBST(list, start, mid-1);
  BinaryTree *parent = new BinaryTree(list->data);
  parent->left = leftChild;
  list = list->next;
  parent->right = sortedListToBST(list, mid+1, end);
  return parent;
}

BinaryTree* sortedListToBST(ListNode *head, int n) {
  return sortedListToBST(head, 0, n-1);
}

*/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) {
            return null;
        }
        ListNode end = head;
        while (end != null) {
            end = end.next;
        }
        return getNode(head, end);
    }
    
    public TreeNode getNode(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;
        if (start == end) {
            return null;
        }
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = getNode(start, slow);
        root.right = getNode(slow.next, end);
        return root;
    }
}
