package medium;

import java.util.*;

public class CopyRandomNode {
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode temp = head;
		RandomListNode head1 = new RandomListNode(head.label);
		RandomListNode temp1 = head1;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(temp, temp1);
		while (temp.next != null) {
			temp1.next = new RandomListNode(temp.next.label);
			map.put(temp, temp1);
			temp1 = temp1.next;
			temp = temp.next;
		}
		map.put(temp, temp1);
		temp = head;
		temp1 = head1;
		while (temp != null) {
			temp1.random = map.getOrDefault(temp.random, null);
			temp1 = temp1.next;
			temp = temp.next;
		}
		return head1;
	}

	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.next = new RandomListNode(3);
//		head.next.next.next = new RandomListNode(4);
//		head.random = head.next.next.next;
		head.next.next.random = head.next;
//		head.next.next.next.random = head.next.next;
		copyRandomList(head);
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};