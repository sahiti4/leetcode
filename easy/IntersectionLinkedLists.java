package easy;

public class IntersectionLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode temp = headA;
		while (temp != null) {
			temp = temp.next;
			lenA++;
		}
		temp = headB;
		while (temp != null) {
			temp = temp.next;
			lenB++;
		}
		while (lenA > lenB) {
			lenA--;
			headA = headA.next;
		}
		while (lenB > lenA) {
			lenB--;
			headB = headB.next;
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	public static void main(String[] args) {
	}

}
