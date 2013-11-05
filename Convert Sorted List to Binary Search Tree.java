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