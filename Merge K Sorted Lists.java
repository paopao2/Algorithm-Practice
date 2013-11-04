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

//merge sort
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode l = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            l = mergeTwoList(l, lists.get(i));
        }
        return l;
    }
    
    public ListNode mergeTwoList(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        
        if (n1.val < n2.val) {
            n1.next = mergeTwoList(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeTwoList(n2.next, n1);
            return n2;
        }
        
    }
}

//heap sort
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue(lists.size(), new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val) return -1;
                if (n1.val > n2.val) return 1;
                return 0;
            }
        });
        
        for (ListNode n : lists) {
            if (n != null) {
                heap.add(n);
            }
        }
        
        ListNode head = heap.poll();
        ListNode cur = head;
        while (!heap.isEmpty()) {
            if (cur.next != null) {
                heap.add(cur.next);
            }
            
            cur.next = heap.poll();
            cur = cur.next;
        }
        return head;
    }
    
}