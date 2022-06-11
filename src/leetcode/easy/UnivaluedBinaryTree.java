package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

public class UnivaluedBinaryTree {

	public boolean isUnivalTree(TreeNode root) {
		int mark = root.val;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.val != mark) {
					return false;
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return true;
	}

}
