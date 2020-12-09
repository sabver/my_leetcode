package leetcode.medium;

import leetcode.util.*;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		return null;
	}

	public static void main(String[] args) {
		PartitionList s = new PartitionList();
		int[] nums = { 1, 4, 3, 2, 5, 2 };
		int x = 0;
		ListNode head = ListNode.create(nums);
		ListNode.print(s.partition(head, x));
	}
}
