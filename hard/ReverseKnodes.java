package hard;

public class ReverseKnodes {

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode previous = null;
		ListNode end = null;
		ListNode result = null;
		int count = 0;
		ListNode temp = head;
		int length = 0;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		if (k > length)
			return head;
		temp = head;
		int s = length / k;
		s = s * k;
		while (temp != null) {
			if (count >= s) {
				break;
			}
			ListNode next = temp.next;
			temp.next = previous;
			previous = temp;
			temp = next;
			count++;
			if (count % k == 0) {
				if (count / k > 1) {
					start.next = previous;
					start = end;
					if (count != s)
						end = temp;
				} else {
					result = previous;
					end = temp;
				}
			}
		}
		if (count / k == 1) {
			start.next = temp;
		} else if (end != null) {
			end.next = temp;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);
		// head.next.next.next.next.next = new ListNode(6);
		// head.next.next.next.next.next.next = new ListNode(7);
		// head.next.next.next.next.next.next.next = new ListNode(8);
		// head.next.next.next.next.next.next.next.next = new ListNode(9);
		reverseKGroup(head, 3);
	}

}
