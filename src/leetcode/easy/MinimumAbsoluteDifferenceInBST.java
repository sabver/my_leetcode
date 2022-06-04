package leetcode.easy;

import leetcode.util.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

	int min = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		helper(root);
		return min;
	}

	public void helper(TreeNode root) {
		if (min == 1) {
			return;
		}
		if (root == null) {
			return;
		}
		TreeNode maxNode = findMax(root.left);
		TreeNode minNode = findMin(root.right);
		if (maxNode != null) {
			min = Math.min(min, Math.abs(root.val - maxNode.val));
		}
		if (minNode != null) {
			min = Math.min(min, Math.abs(root.val - minNode.val));
		}
		helper(root.left);
		helper(root.right);
	}

	public TreeNode findMax(TreeNode root) {
		while (root != null && root.right != null) {
			root = root.right;
		}
		return root;
	}

	public TreeNode findMin(TreeNode root) {
		while (root != null && root.left != null) {
			root = root.left;
		}
		return root;
	}
}
