package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class AverageOfLevelsInBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			int sz = queue.size();
			double sum = 0.0;
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				sum += node.val;
			}
			res.add(1.0 * sum / sz);
		}
		return res;
	}
}
