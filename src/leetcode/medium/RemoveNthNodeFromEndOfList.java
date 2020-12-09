package leetcode.medium;

public class RemoveNthNodeFromEndOfList {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 保留head引用
		ListNode result = head;
		int count = remove(head, head.next, n) + 1;
		// 删除第一个
		if (n == count) {
			result = result.next;
		}
		return result;
	}

	public int remove(ListNode parent, ListNode curNode, int n) {
		if (curNode == null) {
			return 0;
		}
//		if (curNode.next == null) {
//			if (n == 1) {
//				parent.next = curNode.next;
//			}
//			return 1;
//		}
		int reverseNth = remove(curNode, curNode.next, n) + 1;
		// 找到要删除的目标
		if (reverseNth == n) {
			parent.next = curNode.next;
		}
		return reverseNth;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList s = new RemoveNthNodeFromEndOfList();
		 int[] array = { 1, 3, 5, 6, 7, 8, 11, 34 };
//		int[] array = { 1 };
		ListNode node = s.create(array);
		s.print(node);
		node = s.removeNthFromEnd(node, 1);
		s.print(node);
	}
}
