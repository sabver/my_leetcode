package leetcode.medium;

import leetcode.util.ListNode;

public class RotateList {
	private int length;

	public ListNode rotateRight(ListNode head, int k) {
		if( head == null ){
			return null;
		}
		length = 0;
		ListNode tail = getTail(head);
		// 将tail和head链接起来,rotate k次其实就是将head往后挪动k次
		// 或者换个角度，可以将head往前挪动length-k次
		tail.next = head;
		// cut tail insert to head k times
		k = k % length;
		for (int i = 1; i <= length - k; i++) {
			tail = head;
			head = head.next;
		}
		tail.next = null;
		return head;
	}

	public ListNode getTail(ListNode head) {
		this.length++;
		if (head.next == null) {
			return head;
		} else {
			return getTail(head.next);
		}
	}

	public static void main(String[] args) {
		RotateList s = new RotateList();
		int[] array = {  };
		ListNode head = ListNode.create(array);
		ListNode.print(head);
		int k = 4;
		ListNode.print(s.rotateRight(head, k));
	}
}
