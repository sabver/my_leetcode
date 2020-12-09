package leetcode.medium;

public class AddTwoNumbers {
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur = new ListNode(0);
		ListNode result = cur;
		ListNode l1Cur = l1;
		ListNode l2Cur = l2;
		int l1Num = 0;
		int l2Num = 0;
		int num = 0;
		// 是否需要进位
		boolean isPlusOne = false;
		while (l1Cur != null || l2Cur != null) {
			if (l1Cur != null) {
				l1Num = l1Cur.val;
			} else {
				l1Num = 0;
			}
			if (l2Cur != null) {
				l2Num = l2Cur.val;
			} else {
				l2Num = 0;
			}
			if (isPlusOne) {
				num = l1Num + l2Num + 1;
			} else {
				num = l1Num + l2Num;
			}
//			System.out.println("num:" + num);
//			System.out.println("l1Num:" + l1Num);
//			System.out.println("l2Num:" + l2Num);
//			System.out.println("");
			if (num >= 10) {
				isPlusOne = true;
				num -= 10;
			} else {
				isPlusOne = false;
			}
			cur.val = num;
			if (l1Cur != null) {
				l1Cur = l1Cur.next;
			}
			if (l2Cur != null) {
				l2Cur = l2Cur.next;
			}
			if (l1Cur != null || l2Cur != null) {
				cur.next = new ListNode(0);
				cur = cur.next;
			} else if (l1Cur == null && l2Cur == null && isPlusOne) {
				cur.next = new ListNode(1);
				cur = cur.next;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		AddTwoNumbers s = new AddTwoNumbers();
		int[] array1 = { 1, 8 };
		int[] array2 = { 0 };
		ListNode l1 = s.create(array1);
		ListNode l2 = s.create(array2);
		s.print(l1);
		s.print(l2);
		s.print(s.addTwoNumbers(l1, l2));
	}
}
