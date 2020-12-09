package leetcode.easy;

public class MergeTwoSortedLists {
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

	/**
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result = null;
		ListNode cur = null;
		ListNode l1Cur = l1;
		ListNode l2Cur = l2;
		if (l1Cur.val <= l2Cur.val) {
			cur = new ListNode(l1Cur.val);
			result = cur;
			l1Cur = l1Cur.next;
		} else {
			cur = new ListNode(l2Cur.val);
			result = cur;
			l2Cur = l2Cur.next;
		}
		while (l1Cur != null || l2Cur != null) {
			if (l1Cur == null && l2Cur != null) {
//				System.out.println("one:" + l2Cur.val);
				cur.next = new ListNode(l2Cur.val);
				cur = cur.next;
				l2Cur = l2Cur.next;
				continue;
			}
			if (l2Cur == null && l1Cur != null) {
//				System.out.println("two:" + l1Cur.val);
				cur.next = new ListNode(l1Cur.val);
				cur = cur.next;
				l1Cur = l1Cur.next;
				continue;
			}
			if (l1Cur.val <= l2Cur.val) {
//				System.out.println("three:" + l1Cur.val);
				cur.next = new ListNode(l1Cur.val);
				cur = cur.next;
				l1Cur = l1Cur.next;
			} else {
//				System.out.println("four:" + l2Cur.val);
				cur.next = new ListNode(l2Cur.val);
				cur = cur.next;
				l2Cur = l2Cur.next;
			}
		}
		return result;
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

	public void create(ListNode cur, int val) {
		cur.next = new ListNode(val);
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

	public static void main(String[] args) {
		MergeTwoSortedLists s = new MergeTwoSortedLists();
		int[] array1 = { 1, 2, 4 };
		int[] array2 = { 1, 3, 4 };
		ListNode l1 = s.create(array1);
		ListNode l2 = s.create(array2);
		s.print(l1);
		s.print(l2);
		s.print(s.mergeTwoLists(l1, l2));
	}
}
