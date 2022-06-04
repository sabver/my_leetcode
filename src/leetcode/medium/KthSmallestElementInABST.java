package leetcode.medium;

import leetcode.util.TreeNode;

public class KthSmallestElementInABST {
	int res = Integer.MIN_VALUE;
	int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		helper(root, k);
		return res;
	}

	public void helper(TreeNode root, int k) {		
		if (root == null) {
			return;
		}
		helper(root.left, k);
		count++;
		if (count == k) {
			res = root.val;
			return;
		}
		helper(root.right, k);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTreeByArray(new int[] { 5, 3, 6, 2, 4, -1, -1, 1 });
		KthSmallestElementInABST s = new KthSmallestElementInABST();
		int k = 3;
		int result = s.kthSmallest(root, k);
		System.out.println("result:" + result);
	}
}
