package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		List<Integer> list = changeLinkToList(head);
		return inorder(list, 0, list.size() - 1);
	}

	public List<Integer> changeLinkToList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list;
	}

	public TreeNode inorder(List<Integer> nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (end + start) / 2;
		TreeNode root = new TreeNode(nums.get(mid));
		TreeNode left = inorder(nums, start, mid - 1);
		TreeNode right = inorder(nums, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}

}
