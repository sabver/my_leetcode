package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int level = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if (cur == null) {
					continue;
				}
				if (cur.left == null && cur.right == null) {
					return level;
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			level++;
		}
		return Integer.MAX_VALUE;
	}
}
