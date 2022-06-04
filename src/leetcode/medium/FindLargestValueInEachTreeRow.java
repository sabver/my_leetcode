package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if( root == null ) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		res.add(root.val);
		while (!queue.isEmpty()) {
			int sz = queue.size();
			int max = Integer.MIN_VALUE;
			boolean flag = false;
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					max = Math.max(max, node.left.val);
					flag = true;
				}
				if (node.right != null) {
					queue.offer(node.right);
					max = Math.max(max, node.right.val);
					flag = true;
				}
			}
			if (flag)
				res.add(max);
		}
		return res;
	}
}
