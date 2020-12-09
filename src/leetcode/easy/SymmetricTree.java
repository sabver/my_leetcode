package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.*;

public class SymmetricTree {
	/**
	 * 错的代码
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetricError(TreeNode root) {
		if (root == null) {
			return true;
		}
		List<Integer> trace = new ArrayList<Integer>();
		inorder(trace, root);
		int size = trace.size();
		// 对称树的数量一定是奇数
		if (size % 2 == 0) {
			return false;
		}
		for (int i = 0; i < size / 2; i++) {
			if (trace.get(i) != trace.get(size - i - 1)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 用中序是不行的
	 * 
	 * @param trace
	 * @param root
	 */
	public void inorder(List<Integer> trace, TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(trace, root.left);
		trace.add(root.val);
		inorder(trace, root.right);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val == right.val) {
			boolean sameDirection = isSymmetric(left.left, right.right);
			if (sameDirection == false) {
				return false;
			}
			return isSymmetric(left.right, right.left);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		SymmetricTree s = new SymmetricTree();
		TreeNode root = new TreeNode(1);
		System.out.println(s.isSymmetric(root));
	}
}
