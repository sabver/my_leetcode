package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.util.TreeNode;

public class AddOneRowToTree {
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int curDepth = 2;
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (curDepth == depth) {
					TreeNode newLeft = new TreeNode(val);
					TreeNode newRight = new TreeNode(val);
					newLeft.left = node.left;
					newRight.right = node.right;
					node.left = newLeft;
					node.right = newRight;
				}
			}
			if (curDepth == depth) {
				return root;
			}
			curDepth++;
		}
		return root;
	}
}
