package medium;

public class SortList {

	public static ListNode sortList(ListNode head) {
		ListNode mid = null;
		ListNode headC = head;
		ListNode temp = head;
		ListNode previous = null;
		if (head.next == null)
			return head;
		while (temp != null && temp.next != null) {
			previous = headC;
			mid = headC.next;
			headC = headC.next;
			temp = temp.next.next;
		}
		if (previous != null)
			previous.next = null;
		ListNode head1 = sortList(head);
		ListNode head2 = sortList(mid);
		return mergePartitions(head1, head2);

	}

	public static ListNode mergePartitions(ListNode head1, ListNode head2) {
		ListNode head = null;
		if (head1 == null)
			head = head2;
		if (head2 == null)
			head = head1;
		if (head1.val > head2.val) {
			head = head2;
			head2 = head2.next;
		} else {
			head = head1;
			head1 = head1.next;
		}
		ListNode temp = head;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				temp.next = head1;
				temp = temp.next;
				head1 = head1.next;
			} else {
				temp.next = head2;
				temp = temp.next;
				head2 = head2.next;
			}
		}
		while (head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		while (head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		return head;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		// head.next = new ListNode(3);
		head.next = new ListNode(2);
		// head.next.next.next = new ListNode(5);
		// head.next.next.next.next = new ListNode(4);
		printList(sortList(head));
	}

}
