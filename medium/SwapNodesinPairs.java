package medium;

public class SwapNodesinPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head.next == null)
			return head;
		ListNode temp = head;
		ListNode previous = new ListNode(0);
		previous.next = temp;
		ListNode result = previous;
		while (temp != null && temp.next != null) {
			ListNode next = temp.next;
			ListNode third = temp.next.next;
			previous.next = next;
			next.next = temp;
			temp.next = third;
			previous = temp;
			temp = temp.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		swapPairs(head);
	}
}
