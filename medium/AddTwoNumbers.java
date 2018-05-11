package medium;

import java.util.Stack;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode temp = l1;
		int len1 = 0, len2 = 0;
		while (temp != null) {
			len1++;
			temp = temp.next;
		}
		temp = l2;
		while (temp != null) {
			len2++;
			temp = temp.next;
		}
		Stack<Integer> stack1 = new Stack<>();
		temp = len1 > len2 ? l1 : l2;
		while (temp != null) {
			stack1.push(temp.val);
			temp = temp.next;
		}
		temp = len1 > len2 ? l2 : l1;
		Stack<Integer> stack2 = new Stack<>();
		while (temp != null) {
			stack2.push(temp.val);
			temp = temp.next;
		}
		if (stack1.isEmpty() && stack2.isEmpty())
			return null;
		temp = null;
		int carry = 0;
		ListNode temp1 = null;
		while (!stack1.isEmpty()) {
			int sum = stack1.pop() + (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
			carry = sum / 10;
			temp1 = new ListNode(sum % 10);
			temp1.next = temp;
			temp = temp1;
		}
		if (carry > 0)
			temp1 = new ListNode(carry);
		temp1.next = temp;
		temp = temp1;

		return temp;
	}

	public static void main(String[] args) {

		addTwoNumbers(new ListNode(4), new ListNode(6));
	}

}
