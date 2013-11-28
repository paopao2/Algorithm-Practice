/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then le-out nodes in the end should remain as it is. You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example, Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return null;
        ListNode newHead = head;
        for (int i = 0; i < k; i++) {
            if (newHead == null) return head;
            newHead = newHead.next;
        }
        
        ListNode newGroupHead = reverseKGroup(newHead, k);
        ListNode pre = newGroupHead; ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
