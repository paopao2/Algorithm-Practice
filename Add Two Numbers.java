/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int carry = 0;
        ListNode node = null;
        ListNode head = null;
        while(l1 != null || l2 != null || carry != 0) {
            int val = carry;
            val += l1 == null? 0 : l1.val;
            val += l2 == null? 0 : l2.val;
            if (val > 9) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (node == null) {
                node = new ListNode(val);
                head = node;
            } else {
                ListNode cur = new ListNode(val);
                node.next = cur;
                node = cur;
            }
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
    
        return head;
    }
}