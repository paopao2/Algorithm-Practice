/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null || head.next == null) return head;
        ListNode a = head;
        ListNode b = head.next;
        ListNode nex = head.next.next;
        a.next = b.next;
        b.next = a;
        
        ListNode newHead = b;
        while (nex != null && nex.next != null) {
            a.next = nex.next;
            ListNode t = nex.next.next;
            a = nex;
            b = nex.next;
            a.next = b.next;
            b.next = a;
            nex = t;
        }
        
        return newHead;
    }
}