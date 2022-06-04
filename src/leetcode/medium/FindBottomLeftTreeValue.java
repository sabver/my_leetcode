package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int res = root.val;
		while (!queue.isEmpty()) {
			int sz = queue.size();
			boolean flag = false;
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					if (!flag) {
						res = node.left.val;
						flag = true;
					}
				}
				if (node.right != null) {
					queue.offer(node.right);
					if (!flag) {
						res = node.right.val;
						flag = true;
					}
				}
			}
		}
		return res;
	}
}
