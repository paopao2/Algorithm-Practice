/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) return null;
        
        ListNode newHead = null;
        ListNode newTail = null;
        int min = head.val;
        while (head != null) {
            ListNode next = head.next;
            ListNode node = head;
            ListNode curMin = null;
            while (node != null) {
                if (curMin == null) curMin = node;
                if (node.val < curMin.val) curMin = node;
                node = node.next;
            }
            
            if (newHead == null) {
                newHead = curMin;
                newTail = curMin;
            } else {
                newTail.next = curMin;
                newTail = curMin;
            }
            
            //remove curMin from original list
            node = head;
            if (curMin == head) {
                head = next;
            } else {
                while (node.next != null) {
                    if (node.next == curMin) {
                        node.next = node.next.next;
                        break;
                    }
                    node = node.next;
                }
            }
            
        }
        return newHead; 
    }
}