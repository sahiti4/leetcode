package easy;

public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		if (head.next != null || head == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode reverse = reverse(slow);
		while (reverse != null) {
			if (reverse.val != head.val)
				return false;
			reverse = reverse.next;
			head = head.next;
		}
		return true;
	}

	public static ListNode reverse(ListNode head) {
		ListNode temp = head;
		ListNode previous = null;
		ListNode next = head.next;
		if (head.next == null)
			return head;
		while (next != null) {
			next = temp.next;
			temp.next = previous;
			previous = temp;
			temp = next;
		}
		return previous;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		// head.next = new ListNode(2);
		// head.next = new ListNode(1);
		System.out.println(isPalindrome(head));
	}

}
