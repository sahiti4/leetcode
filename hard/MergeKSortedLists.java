package hard;

import java.util.*;

public class MergeKSortedLists {

	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				queue.add(lists[i]);
		}
		if (queue.isEmpty())
			return null;
		ListNode head = queue.poll();
		ListNode temp = head;
		if (head.next != null)
			queue.add(head.next);
		while (!queue.isEmpty()) {
			ListNode current = queue.poll();
			if (current.next != null)
				queue.add(current.next);
			temp.next = current;
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(0);
		ListNode[] lists = new ListNode[2];
		lists[0] = head1;
		lists[1] = head2;
		mergeKLists(lists);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
