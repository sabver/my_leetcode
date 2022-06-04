package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.util.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		// 控制层次
		while (queue.size() > 0) {
			List<Integer> levelResult = new ArrayList<>();
			// 控制当层节点输出
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode cur = queue.poll();
				if( cur == null ) {
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
			if (levelResult.size() > 0) {
				stack.push(levelResult);
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		while( !stack.empty() ) {
			result.add(stack.pop());
		}
		return result;
    }
}
