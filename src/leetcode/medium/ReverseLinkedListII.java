package leetcode.medium;

import leetcode.util.*;

public class ReverseLinkedListII {
	ListNode beforeReverseOne;
	ListNode afterReverseOne;
	ListNode firstReverseOne;
	ListNode endReverseOne;
	ListNode endNode;

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode result = head;
		reverseBetween(null,head, m, n, 1);
		// 如果第一个就要倒转
		if (m == 1) {
			return endReverseOne;
		}
		return result;
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @param cur
	 */
	public void reverseBetween(ListNode lastNode, ListNode curNode, int m, int n, int cur) {
		if (curNode == null) {
			return;
		}
		if (curNode.next == null) {
			endNode = lastNode;
		}
		if (m - 1 == cur) { //当m=1时，这个条件是有可能不触发的
			beforeReverseOne = curNode;
			// 这里在输入上保证了lastNode不会空
			reverseBetween(curNode, curNode.next, m, n, cur + 1);
			beforeReverseOne.next = endReverseOne;
		} else if (n + 1 == cur) {
			// afterReverseOne可能为空
			afterReverseOne = curNode;
			reverseBetween(curNode, curNode.next, m, n, cur + 1);
		} else if (cur >= m && cur <= n) { // 这里在输入的时候就保证了curNode不会空
			if (cur == m) {
				firstReverseOne = curNode;
			}
			if (cur == n) {
				endReverseOne = curNode;
			}
			ListNode nextNode = curNode.next;
			// 倒转
			curNode.next = lastNode;
			reverseBetween(curNode, nextNode, m, n, cur + 1);
			if (cur == m) {
				firstReverseOne.next = afterReverseOne;
			}
		} else {
			reverseBetween(curNode, curNode.next, m, n, cur + 1);
		}
	}

	public static void main(String[] args) {
		ReverseLinkedListII s = new ReverseLinkedListII();
		int[] array = { 1, 2, 3, 4, 5 };
		ListNode head = ListNode.create(array);
		int m = 1;
		int n = 5;
		ListNode.print(s.reverseBetween(head, m, n));
	}
}
