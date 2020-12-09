package leetcode.medium;

public class SwapNodesInPairs {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public String toString() {
			String result = "val:" + val;
			if (next != null) {
				result += (" next:" + next.val);
			}
			return result;
		}
	}

	public ListNode create(int[] array) {
		if (array.length == 0) {
			return null;
		}
		ListNode cur = new ListNode(array[0]);
		ListNode result = cur;
		for (int i = 1; i < array.length; i++) {
			cur.next = new ListNode(array[i]);
			cur = cur.next;
		}
		return result;
	}

	public void print(ListNode node) {
		ListNode cur = node;
		String result = "";
		while (cur != null) {
			result += (cur.val + "->");
			// System.out.println(cur);
			cur = cur.next;
		}
		System.out.println(result);
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = head.next;
		swap(null, head);
		return result;
	}

	public void swap(ListNode parent, ListNode node) {
		if (node != null) {
			ListNode next = node.next;
			if (next != null) {
				node.next = next.next;
				next.next = node;
				if (parent != null) {
					parent.next = next;
				}
				swap(node, node.next);
			}
		}
	}

	public static void main(String[] args) {
		SwapNodesInPairs s = new SwapNodesInPairs();
		int[] array = { 1, 2, 3 };
		ListNode node = s.create(array);
		s.print(node);
		node = s.swapPairs(node);
		s.print(node);
	}

}
