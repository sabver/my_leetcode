package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;

public class MaximumDepthOfBinaryTreeV2 {
	int max = 0;

	public int maxDepth(TreeNode root) {
		if( root == null ) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		// 控制层次
		int level = 1;
		while (queue.size() > 0) {
			List<Integer> levelResult = new ArrayList<>();
			// 控制当层节点输出
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if (cur == null) {
					continue;
				}
				levelResult.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			if( queue.size() > 0 ) {
				level++;
			}			
		}
		return level;
	}
}
