package leetcode.easy;

import leetcode.util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return inorder(nums, 0, nums.length - 1);
	}

	public TreeNode inorder(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (end + start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		TreeNode left = inorder(nums, start, mid - 1);
		TreeNode right = inorder(nums, mid + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
