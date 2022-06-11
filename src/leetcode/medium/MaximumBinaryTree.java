package leetcode.medium;

import leetcode.util.TreeNode;

public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = start; i <= end; i++) {
			if (nums[i] >= max) {
				maxIndex = i;
				max = nums[i];
			}
		}
		TreeNode root = new TreeNode(max);
		root.left = helper(nums, start, maxIndex - 1);
		root.right = helper(nums, maxIndex + 1, end);
		return root;
	}

}
