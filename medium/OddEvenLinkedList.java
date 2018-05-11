package medium;

public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode oddPtr = head;
		ListNode evenPtr = head.next;
		ListNode resultO = oddPtr;
		ListNode resultE = evenPtr;
		while (evenPtr != null && evenPtr.next != null) {
			oddPtr.next = oddPtr.next.next;
			oddPtr = oddPtr.next;
			evenPtr.next = oddPtr.next;
			evenPtr = evenPtr.next;
		}
		oddPtr.next = resultE;
		return resultO;
	}

	public static void main(String[] args) {
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		h.next.next = new ListNode(3);
		h.next.next.next = new ListNode(4);
		h.next.next.next.next = new ListNode(5);
		h.next.next.next.next.next = new ListNode(6);
		oddEvenList(null);
	}

}
