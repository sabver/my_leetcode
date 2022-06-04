package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.util.TreeNode;
import leetcode.util.Util;

public class BinaryTreeLevelOrderTraversalV2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
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
				result.add(levelResult);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalV2 s = new BinaryTreeLevelOrderTraversalV2();
		int array[] = { 3, 9, 20, -1, -1, 15, 7 };
		TreeNode root = TreeNode.createTreeByArray(array);
		System.out.println(root);
		Util.printList(s.levelOrder(root));
	}
}
