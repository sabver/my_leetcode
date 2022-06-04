package leetcode.hard;

import leetcode.util.TreeNode;

public class BinaryTreeMaximumPathSum {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		oneSideMax(root);
		return max;
	}

	public int oneSideMax(TreeNode root) {
		if (root == null || root.val == Integer.MIN_VALUE) {
			return 0;
		}
		int leftMax = Math.max(0, oneSideMax(root.left));
		int rightMax = Math.max(0, oneSideMax(root.right));
		int pathSum = root.val + leftMax + rightMax;
		max = Math.max(max, pathSum);
		return Math.max(leftMax, rightMax) + root.val;
	}

	public static void main(String args[]) {
		int[] nums = new int[] { 5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE, 1 };
		TreeNode root = TreeNode.createTreeByArray(nums);
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		int res = b.maxPathSum(root);
		System.out.println("res: " + res);
	}
}
