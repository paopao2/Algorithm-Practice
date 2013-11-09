/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


//can't pass large data test
public class Solution {
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondHead = slow.next;
        slow.next = null;
        
        ListNode node = head;
        while (node != null) {
            node = findLastAndInsert(node, secondHead);
        }
    }
    
    public ListNode findLastAndInsert(ListNode cur, ListNode head) {
        if (cur.next == null || head == null) {
            return null;
        }
        ListNode next = cur.next;
        ListNode node = head;
        
        if (node.next == null) {
            node.next = cur.next;
            cur.next = node.next;
            return null;
        }
        
        while (node.next.next != null) {
            node = node.next;
        }
        node.next.next = cur.next;
        cur.next = node.next;
        node.next = null;
        
        return next;
    }
}

//O(N) run time

public class Solution {
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (head == null) {
            return;
        }
        
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        
        int back = list.size() - 1;
        int front = 0;
        
        while (back > front) {
            ListNode a = list.get(front);
            ListNode b = list.get(back);
            
            b.next = a.next;
            a.next = b;
            
            back--;
            front++;
        }
        if (back == front) {
            list.get(back).next = null;
        } else {
            list.get(back + 1).next = null;
        }
    }
    
}