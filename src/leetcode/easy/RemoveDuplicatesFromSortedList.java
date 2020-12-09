package leetcode.easy;

import leetcode.util.*;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = head;
		ListNode lastItem = head;
		ListNode curItem = null;
		while (lastItem.next != null) {
			curItem = lastItem.next;
			if (lastItem.val == curItem.val) {
				lastItem.next = curItem.next;
			}else{
				lastItem = curItem;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
		int[] nums = { 1, 2, 3, 3, 4, 4, 5 };
		ListNode head = ListNode.create(nums);
		ListNode.print(head);
		ListNode.print(s.deleteDuplicates(head));
	}
}
