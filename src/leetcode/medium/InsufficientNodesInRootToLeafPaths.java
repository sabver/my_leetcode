package leetcode.medium;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class InsufficientNodesInRootToLeafPaths {

	public TreeNode sufficientSubset(TreeNode root, int limit) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			if (root.val < limit) {
				return null;
			} else {
				return root;
			}
		}
		TreeNode left = sufficientSubset(root.left, limit - root.val);
		TreeNode right = sufficientSubset(root.right, limit - root.val);
		if (left == null && right == null) {
			return null;
		}
		root.left = left;
		root.right = right;
		return root;
	}

	public static void main(String args[]) {
		InsufficientNodesInRootToLeafPaths i = new InsufficientNodesInRootToLeafPaths();
		int[] nums = new int[] { 1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14 };
		int limit = 1;
		TreeNode root = TreeNode.createTreeByArray(nums);
		Util.printBinaryTree(root);
		Util.printBinaryTree(i.sufficientSubset(root, limit));
	}

}
