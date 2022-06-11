package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import leetcode.util.TreeNode;

public class AllPossibleFullBinaryTrees {
	List<TreeNode>[] memo;

	public List<TreeNode> allPossibleFBT(int n) {
		if (n % 2 == 0) {
			return new ArrayList<>();
		}
		memo = new ArrayList[n + 1];
		return helper(n);
	}

	public List<TreeNode> helper(int n) {
		List<TreeNode> list = new ArrayList<>();
		// base
		if (n == 1) {
			list.add(new TreeNode(0));
			return list;
		}
		if (memo[n] != null) {
			return memo[n];
		}
		// n是奇数，这里要确保i和j都是奇数才行
		for (int i = 1; i <= n; i += 2) {
			// i => left tree num
			// j => right tree num
			int j = n - i - 1;
			List<TreeNode> leftTrees = helper(i);
			List<TreeNode> rightTrees = helper(j);
			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode root = new TreeNode(0);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		memo[n] = list;
		return list;
	}

}
