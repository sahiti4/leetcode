package easy;

import java.util.*;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode temp = head;
		set.add(temp);
		while (temp != null) {
			if (set.contains(temp))
				return true;
			temp = temp.next;
			set.add(temp);
		}
		return false;
	}

	public static void main(String[] args) {

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
