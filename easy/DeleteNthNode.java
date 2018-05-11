package easy;

public class DeleteNthNode {
	public void deleteNode(ListNode node) {
		ListNode temp = node;
		ListNode previous = null;
		if (temp.next != null)
			node = null;
		while (temp.next != null) {
			previous = temp;
			temp.val = temp.next.val;
			temp = temp.next;
		}
		if (previous != null)
			previous.next = null;
	}
}
