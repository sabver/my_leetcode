package leetcode.easy;

import leetcode.util.*;

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMaxDepth = maxDepth(root.left);
		int rightMaxDepth = maxDepth(root.right);
		return Math.max(leftMaxDepth, rightMaxDepth) + 1;
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree s = new MaximumDepthOfBinaryTree();
		int array[] = { 3, 9, 20, -1, -1, 15, 7 };
		TreeNode root = TreeNode.createTreeByArray(array);
		System.out.println(root);
		System.out.println(s.maxDepth(root));
	}
}
