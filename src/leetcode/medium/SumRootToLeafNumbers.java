package leetcode.medium;

import leetcode.util.TreeNode;

public class SumRootToLeafNumbers {
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root, root.val);
		return sum;
	}

	public void helper(TreeNode root, int preSum) {
		if (root == null) {
			return;
		}
		System.out.println("root:" + root.toString());
		System.out.println("preSum:" + preSum);
		if (root.left == null && root.right == null) {
			sum += preSum;
		}
		if (root.left != null) {
			helper(root.left, preSum * 10 + root.left.val);
		}
		if (root.right != null) {
			helper(root.right, preSum * 10 + root.right.val);
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createTreeByArray(new int[] { 1, 2, 3 });
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		int result = s.sumNumbers(root);
		System.out.println("result:" + result);
	}

}
