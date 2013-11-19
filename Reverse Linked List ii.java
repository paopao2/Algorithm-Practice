/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode beforeTail, afterHead;
        //initialize beforeTail
        if (m == 1) beforeTail = null;
        else {
            beforeTail = head;
            while (m > 2) {
                beforeTail = beforeTail.next;
                m--;
            }
        }
        //initialize afterHead
        afterHead = head;
        while (n > 0) {
            afterHead = afterHead.next;
            n--;
        }
        
        ListNode node = beforeTail == null? head : beforeTail.next;
        ListNode tail = afterHead;
        while (node != afterHead) {
            ListNode next = node.next;
            node.next = tail;
            tail = node;
            node = next;
        }
        if (beforeTail == null) return tail;
        else {
            beforeTail.next = tail;
            return head;
        }
    }
}