package leetcode.util;

public class ListNode {
	public int val;
	public ListNode next;

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

	public static ListNode create(int[] array) {
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

	public static void print(ListNode node) {
		ListNode cur = node;
		String result = "";
		while (cur != null) {
			result += (cur.val + "->");
			// System.out.println(cur);
			cur = cur.next;
		}
		System.out.println(result);
	}
}
