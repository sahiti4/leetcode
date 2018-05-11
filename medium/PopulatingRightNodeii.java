package medium;

public class PopulatingRightNodeii {

	public static void connect(TreeLinkNode root) {
		TreeLinkNode initial = root;
		while (initial != null) {
			TreeLinkNode previous = null;
			if (initial == root)
				initial = null;
			if (root.left != null) {
				initial = root.left;
				previous = root.left;
			}
			if (root.right != null) {
				initial = initial == null ? root.right : initial;
				if (previous == null) {
					previous = root.right;
				} else {
					previous.next = root.right;
					previous = previous.next;
				}
			}
			while (root.next != null) {
				root = root.next;
				if (root.left != null) {
					initial = initial == null ? root.left : initial;
					if (previous == null) {
						previous = root.left;
					} else {
						previous.next = root.left;
						previous = previous.next;
					}
				}
				if (root.right != null) {
					initial = initial == null ? root.right : initial;
					if (previous == null) {
						previous = root.right;
					} else {
						previous.next = root.right;
						previous = previous.next;
					}
				}
			}
			root = initial;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(-1);
		root.left = new TreeLinkNode(-7);
		root.right = new TreeLinkNode(9);
		root.right.left = new TreeLinkNode(-1);
		root.right.right = new TreeLinkNode(-7);
		root.right.left.right = new TreeLinkNode(8);
		root.right.right.left = new TreeLinkNode(-9);
		connect(root);
		System.out.println(root.val);
	}

}
