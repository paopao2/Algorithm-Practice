/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode node = head;
        HashSet<ListNode> duplicates = new HashSet<ListNode>();
        
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                duplicates.add(node);
            } else {
                node = node.next;
            }
        }
        
        node = head;
        
        while (node != null) {
            if (duplicates.contains(node.next)) {
                duplicates.remove(node.next);
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        if (duplicates.contains(head)) {
            head = head.next;
        }
        return head;
    }
}