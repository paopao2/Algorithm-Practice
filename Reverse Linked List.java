//interative
public ListNode reverseLinkedList(ListNode head) {
	if (head == null) return null;
	ListNode pre = null;
	ListNode cur = head;
	while (cur != null) {
		ListNode next = cur.next;
		cur.next = pre;
		pre = cur;
		cur = next;
	}
	head = prev;
	return head;
}

//recursive
public ListNode reverseLinkedList(ListNode head) {
	if (head == null) return null;
	if (head.next == null) return head;

	ListNode newHead = reverseLinkedList(head.next);
	head.next.next = head;
	head.next = null;

	return newHead;
}