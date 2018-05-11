package medium;

public class DeleteNthNode {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int count = n;
		ListNode temp = head;
		ListNode result = temp;
		while (count > 0) {
			temp = temp.next;
			count--;
		}
		ListNode previous = head;
		ListNode current = head;
		ListNode next = head.next;
		if (temp == null) {
			return head.next;
		}
		while (temp != null) {
			previous = current;
			next = current.next.next;
			current = current.next;
			temp = temp.next;
		}
		previous.next = next;
		return result;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		removeNthFromEnd(l, 3);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
