/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if (head == null) {
            return head;
        }
        
        ListNode node1 = head;
        ListNode node2 = head;
        int length = 0;
        while (node1 != null) {
            node1 = node1.next;
            length++;
        }
        n = n % length;
        
        if (n == 0 || length == 1) {
            return head;
        }
        node1 = head;
        while (n > 0 && node1 != null) {
            node1 = node1.next;
            n--;
        }
        
        while (node1 != null && node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        ListNode newHead = node2.next;
        node2.next = null;
        node1.next = head;
        return newHead;
    }
}